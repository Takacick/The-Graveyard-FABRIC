package com.finallion.graveyard.entities;

import com.finallion.graveyard.entities.ai.goals.GhoulMeleeAttackGoal;
import com.finallion.graveyard.init.TGSounds;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GhoulEntity extends AngerableGraveyardEntity implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final UUID SLOWNESS_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A1");
    private static final EntityAttributeModifier SLOWNESS_EFFECT;

    private static final TrackedData<Byte> VARIANT;
    private static final TrackedData<Integer> ATTACK_ANIM_TIMER;
    private static final TrackedData<Integer> RAGE_ANIM_TIMER;
    private static final TrackedData<Integer> ANIMATION;
    private static final TrackedData<Integer> SPAWN_TIMER;
    private static final TrackedData<Boolean> IS_RAGING;

    private final AnimationBuilder DEATH_ANIMATION = new AnimationBuilder().addAnimation("death", ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    private final AnimationBuilder IDLE_ANIMATION = new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP);
    private final AnimationBuilder WALK_ANIMATION = new AnimationBuilder().addAnimation("walk", ILoopType.EDefaultLoopTypes.LOOP);
    private final AnimationBuilder RAGE_ANIMATION = new AnimationBuilder().addAnimation("rage", ILoopType.EDefaultLoopTypes.LOOP);
    private final AnimationBuilder RUNNING_ANIMATION = new AnimationBuilder().addAnimation("running", ILoopType.EDefaultLoopTypes.LOOP);
    private final AnimationBuilder ATTACK_ANIMATION = new AnimationBuilder().addAnimation("attack", ILoopType.EDefaultLoopTypes.LOOP);
    private final AnimationBuilder SPAWN_ANIMATION = new AnimationBuilder().addAnimation("spawn", ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    protected static final int ANIMATION_IDLE = 0;
    protected static final int ANIMATION_WALK = 1;
    protected static final int ANIMATION_RAGE = 2;
    protected static final int ANIMATION_DEATH = 3;
    protected static final int ANIMATION_RUNNING = 4;
    protected static final int ANIMATION_MELEE = 5;
    protected static final int ANIMATION_SPAWN = 6;

    public final int ATTACK_ANIMATION_DURATION = 14;
    public final int RAGE_ANIMATION_DURATION = 35;
    public final int RAGE_ANIMATION_COOLDOWN = 300;

    public GhoulEntity(EntityType<? extends GhoulEntity> entityType, World world) {
        super(entityType, world, "ghoul");
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();

        // selects one of eight skins for the ghoul
        byte variant = (byte) random.nextInt(8);

        this.dataTracker.startTracking(VARIANT, variant);
        this.dataTracker.startTracking(ANIMATION, ANIMATION_IDLE);
        this.dataTracker.startTracking(ATTACK_ANIM_TIMER, 0);
        this.dataTracker.startTracking(RAGE_ANIM_TIMER, 0);
        this.dataTracker.startTracking(SPAWN_TIMER, 32);
        this.dataTracker.startTracking(IS_RAGING, false);
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new GhoulMeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }


    public static DefaultAttributeContainer.Builder createGhoulAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.175D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D);
    }


    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public int getAnimationState() {
        return this.dataTracker.get(ANIMATION);
    }

    public void setAnimationState(int state) {
        this.dataTracker.set(ANIMATION, state);
    }

    public int getAttackAnimTimer() {
        return (Integer) this.dataTracker.get(ATTACK_ANIM_TIMER);
    }

    public void setAttackAnimTimer(int time) {
        this.dataTracker.set(ATTACK_ANIM_TIMER, time);
    }

    public int getSpawnTimer() {
        return (Integer) this.dataTracker.get(SPAWN_TIMER);
    }

    public void setSpawnTimer(int ticks) {
        this.dataTracker.set(SPAWN_TIMER, ticks);
    }

    public int getRageAnimTimer() {
        return (Integer) this.dataTracker.get(RAGE_ANIM_TIMER);
    }

    public void setRageAnimTimer(int time) {
        this.dataTracker.set(RAGE_ANIM_TIMER, time);
    }

    public boolean isRaging() {
        return this.dataTracker.get(IS_RAGING);
    }

    public void setIsRaging(boolean raging) {
        this.dataTracker.set(IS_RAGING, raging);
    }

    public byte getVariant() {
        return dataTracker.get(VARIANT);
    }

    public void setVariant(byte variant) {
        dataTracker.set(VARIANT, variant);
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        float limbSwingAmount = event.getLimbSwingAmount();
        boolean isMoving = !(limbSwingAmount > -0.05F && limbSwingAmount < 0.05F);

        /* SPAWN */
        if (getSpawnTimer() > 0) {
            event.getController().setAnimation(SPAWN_ANIMATION);
            return PlayState.CONTINUE;
        }

        /* DEATH */
        if (this.isDead() || this.getHealth() < 0.01) {
            event.getController().setAnimation(DEATH_ANIMATION);
            return PlayState.CONTINUE;
        }

        /* ATTACK */
        // takes one tick to get to this method (from mobtick)
        if (getAnimationState() == ANIMATION_MELEE && getAttackAnimTimer() == (ATTACK_ANIMATION_DURATION - 1) && isAttacking() && !(this.isDead() || this.getHealth() < 0.01)) {
            setAttackAnimTimer(ATTACK_ANIMATION_DURATION - 2);
            event.getController().setAnimation(ATTACK_ANIMATION);
            return PlayState.CONTINUE;
        }

        /* RAGE */
        if (getAnimationState() == ANIMATION_RAGE && getRageAnimTimer() == (RAGE_ANIMATION_DURATION - 1) && isRaging()) {
            event.getController().setAnimation(RAGE_ANIMATION);
            return PlayState.CONTINUE;
        }

        /* WALK */
        if ((event.isMoving() || isMoving) && getAttackAnimTimer() <= 0 && !isRaging()) {
            if (isAttacking() && !isWet()) {
                event.getController().setAnimation(RUNNING_ANIMATION);
            } else {
                event.getController().setAnimation(WALK_ANIMATION);
            }
            return PlayState.CONTINUE;
        }

        if (!event.isMoving() && !isRaging()) {
            event.getController().setAnimation(IDLE_ANIMATION);
        }

        /* IDLE */
        if (getAnimationState() == ANIMATION_IDLE && getAttackAnimTimer() <= 0 && !event.isMoving()) {
            setAnimationState(ANIMATION_IDLE);
            return PlayState.CONTINUE;
        }

        /* STOPPERS */
        // stops idle animation from looping
        if (getAnimationState() == ANIMATION_IDLE && getAttackAnimTimer() > 0) {
            setAnimationState(ANIMATION_MELEE);
            return PlayState.STOP;
        }

        // stops attack animation from looping
        if (getAttackAnimTimer() <= 0 && !(this.isDead() || this.getHealth() < 0.01) && getAnimationState() != ANIMATION_RAGE) {
            setAnimationState(ANIMATION_IDLE);
            return PlayState.STOP;
        }

        return PlayState.CONTINUE;
    }

    protected void mobTick() {
        // ATTACK TIMER
        if (this.getAttackAnimTimer() == ATTACK_ANIMATION_DURATION) {
            setAnimationState(ANIMATION_MELEE);
            if (getRageAnimTimer() <= 0) {
                setRageAnimTimer(RAGE_ANIMATION_COOLDOWN);
            }
        }

        // RAGE TIMER
        if (this.getRageAnimTimer() == RAGE_ANIMATION_DURATION) {
            this.playSound(TGSounds.GHOUL_ROAR, 1.0F, 1.0F);
            setIsRaging(true);
            setAnimationState(ANIMATION_RAGE);
            aggroMobs();
        }

        if (this.getAttackAnimTimer() > 0) {
            int animTimer = this.getAttackAnimTimer() - 1;
            this.setAttackAnimTimer(animTimer);
        }

        if (this.getRageAnimTimer() > 0) {
            int animTimer = this.getRageAnimTimer() - 1;
            this.setRageAnimTimer(animTimer);
        }

        if (this.getRageAnimTimer() == 0) {
            setIsRaging(false);
        }

        if (this.getSpawnTimer() > 0) {
            this.setSpawnTimer(getSpawnTimer() - 1);
        }

        super.mobTick();
    }

    @Override
    public void tickMovement() {
        EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (isRaging()) {
            if (!entityAttributeInstance.hasModifier(SLOWNESS_EFFECT)) {
                entityAttributeInstance.addTemporaryModifier(SLOWNESS_EFFECT);
            }
        } else {
            if (entityAttributeInstance.hasModifier(SLOWNESS_EFFECT)) {
                entityAttributeInstance.removeModifier(SLOWNESS_EFFECT);
            }
        }

        /*
        if (getSpawnTimer() > 0 && world != null && world.isClient()) {
            MinecraftClient.getInstance().particleManager.addBlockBreakParticles(this.getBlockPos().down(), world.getBlockState(this.getBlockPos().down()));
        }

         */

        super.tickMovement();
    }

    @Override
    public void tick() {
        if (getSpawnTimer() > 0 && world != null) {
            //MinecraftClient.getInstance().particleManager.addBlockBreakParticles(this.getBlockPos().down(), world.getBlockState(this.getBlockPos().down()));
            Random random = this.getRandom();
            BlockState blockState = this.getLandingBlockState();
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                for(int i = 0; i < 30; ++i) {
                    double d = this.getX() + (double) MathHelper.nextBetween(random, -0.7F, 0.7F);
                    double e = this.getY();
                    double f = this.getZ() + (double)MathHelper.nextBetween(random, -0.7F, 0.7F);
                    this.world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), d, e, f, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        super.tick();
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("ghoulVariant", getVariant());
        nbt.putInt("spawnTimer", getSpawnTimer());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        setVariant(nbt.getByte("ghoulVariant"));
        setSpawnTimer(nbt.getInt("spawnTimer"));
    }

    private void aggroMobs() {
        if (getTarget() != null) {
            List<HordeGraveyardEntity> monster = world.getEntitiesByClass(HordeGraveyardEntity.class, new Box(getBlockPos()).expand(45.0D), this::canSee);
            for (HordeGraveyardEntity entity : monster) {
                entity.setTarget(getTarget());
            }
        }
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void playAmbientSound() {
        this.playSound(SoundEvents.ENTITY_HUSK_AMBIENT, 1.0F, -5.0F);
    }

    @Override
    protected void playHurtSound(DamageSource source) {
        this.playSound(SoundEvents.ENTITY_HUSK_HURT, 1.0F, -5.0F);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        this.playSound(SoundEvents.ENTITY_HUSK_DEATH, 1.0F, -5.0F);
    }

    static {
        VARIANT = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.BYTE);
        ATTACK_ANIM_TIMER = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.INTEGER);
        RAGE_ANIM_TIMER = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.INTEGER);
        ANIMATION = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.INTEGER);
        SPAWN_TIMER = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.INTEGER);
        IS_RAGING = DataTracker.registerData(GhoulEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        SLOWNESS_EFFECT = new EntityAttributeModifier(SLOWNESS_ID, "Slowness effect", -0.3D, EntityAttributeModifier.Operation.ADDITION);
    }

}

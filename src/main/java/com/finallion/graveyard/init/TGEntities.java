package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TGEntities {

    public static final EntityType<SkeletonCreeper> SKELETON_CREEPER = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SkeletonCreeper::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build();
    public static final EntityType<AcolyteEntity> ACOLYTE = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AcolyteEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build();
    public static final EntityType<GhoulEntity> GHOUL = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GhoulEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build();
    public static final EntityType<ReaperEntity> REAPER = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ReaperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build();

    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(TheGraveyard.MOD_ID, "skeleton_creeper"), SKELETON_CREEPER);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(TheGraveyard.MOD_ID, "acolyte"), ACOLYTE);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(TheGraveyard.MOD_ID, "ghoul"), GHOUL);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(TheGraveyard.MOD_ID, "reaper"), REAPER);
    }



}

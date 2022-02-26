package com.finallion.graveyard.mixin;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.blockentities.GravestoneBlockEntity;
import com.finallion.graveyard.blocks.GravestoneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.network.packet.c2s.play.UpdateSignC2SPacket;
import net.minecraft.server.filter.TextStream;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;


@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Shadow
    public ServerPlayerEntity player;

    @Inject(method = "onSignUpdate(Lnet/minecraft/network/packet/c2s/play/UpdateSignC2SPacket;Ljava/util/List;)V", at = @At(value = "HEAD"), cancellable = true)
    private void signUpdate(UpdateSignC2SPacket packet, List<TextStream.Message> signText, CallbackInfo info) {
        this.player.updateLastActionTime();
        ServerWorld serverWorld = this.player.getWorld();
        BlockPos blockPos = packet.getPos();
        if (serverWorld.isChunkLoaded(blockPos)) {
            BlockState blockState = serverWorld.getBlockState(blockPos);
            Block block = serverWorld.getBlockState(blockPos).getBlock();


            if (block instanceof GravestoneBlock) {
                GravestoneBlockEntity signBlockEntity = (GravestoneBlockEntity) serverWorld.getBlockEntity(blockPos);

                if (!signBlockEntity.isEditable() || !this.player.getUuid().equals(signBlockEntity.getEditor())) {
                    TheGraveyard.LOGGER.warn("Player {} just tried to change non-editable sign", this.player.getName().getString());
                    return;
                }

                for (int i = 0; i < signText.size(); ++i) {
                    TextStream.Message message = (TextStream.Message)signText.get(i);
                    if (this.player.shouldFilterText()) {
                        signBlockEntity.setTextOnRow(i, new LiteralText(message.getFiltered()));
                    } else {
                        signBlockEntity.setTextOnRow(i, new LiteralText(message.getRaw()), new LiteralText(message.getFiltered()));
                    }
                }

                signBlockEntity.markDirty();
                serverWorld.updateListeners(blockPos, blockState, blockState, 3);
                info.cancel();
            }
        }
    }


}

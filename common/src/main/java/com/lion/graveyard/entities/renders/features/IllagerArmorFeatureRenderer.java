package com.lion.graveyard.entities.renders.features;

import com.lion.graveyard.entities.CorruptedIllager;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;


public class IllagerArmorFeatureRenderer<T extends CorruptedIllager> extends BipedEntityModel<T> {
    public IllagerArmorFeatureRenderer(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createOuterArmorLayer() {
        ModelData meshdefinition = BipedEntityModel.getModelData(new Dilation(1.0F), 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F,
                8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
        return TexturedModelData.of(meshdefinition, 64, 32);
    }

    public static TexturedModelData createInnerArmorLayer() {
        ModelData meshdefinition = BipedEntityModel.getModelData(new Dilation(0.5F), 0.0F);
        return TexturedModelData.of(meshdefinition, 64, 32);
    }
}
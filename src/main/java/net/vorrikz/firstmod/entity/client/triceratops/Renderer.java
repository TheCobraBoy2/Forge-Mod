package net.vorrikz.firstmod.entity.client.triceratops;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.entity.TriceratopsVariant;
import net.vorrikz.firstmod.entity.custom.TriceratopsEntity;

import java.util.Map;

// So my parchment version is like way bad for entities.
public class Renderer extends MobRenderer<TriceratopsEntity, Model<TriceratopsEntity>> {
    private static final Map<TriceratopsVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TriceratopsVariant.class), map -> {
                map.put(TriceratopsVariant.GRAY,
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "textures/entity/triceratops/triceratops_gray.png"));
                map.put(TriceratopsVariant.GREEN,
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "textures/entity/triceratops/triceratops_green.png"));
            });

    public Renderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new Model<>(p_174304_.bakeLayer(Model.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation createRenderState(TriceratopsEntity p_114482_) {
        return LOCATION_BY_VARIANT.get(p_114482_.getVariant());
    }

    @Override
    public void render(TriceratopsEntity p_115308_, float p_115309_, float p_115310_, PoseStack p_115311_, MultiBufferSource p_115312_, int p_115313_) {
        if (p_115308_.isBaby()) {
            p_115311_.scale(0.5f, 0.5f, 0.5f);
        } else {
            p_115311_.scale(1f, 1f, 1f);
        }
        super.render(p_115308_, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}

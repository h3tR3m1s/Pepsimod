package ml.jozefpeeterslaan72wuustwezel.pepsimc.client.animation.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import ml.jozefpeeterslaan72wuustwezel.pepsimc.client.animation.model.RecyclerModel;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.entity.blockentity.RecyclerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class RecyclerRenderer extends GeoBlockRenderer<RecyclerEntity> {

	public RecyclerRenderer(Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new RecyclerModel());
	}
	
	@Override
	public RenderType getRenderType(RecyclerEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

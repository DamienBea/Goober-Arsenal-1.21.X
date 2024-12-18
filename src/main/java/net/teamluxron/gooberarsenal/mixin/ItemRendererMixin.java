package net.teamluxron.gooberarsenal.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;
import net.teamluxron.gooberarsenal.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useFryinPanModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
           boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.FRYING_PAN) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "frying_pan_3d")));
        }
        if (stack.isOf(ModItems.DIAMOND_SWORDED) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "diamond_sworded_3d")));
        }
        if (stack.isOf(ModItems.BEE_BUNNY_BASHER) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "bee_bunny_basher_3d")));
        }
        if (stack.isOf(ModItems.STAHP_SIGN) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "stahp_sign_3d")));
        }
        if (stack.isOf(ModItems.STEEL_PIPE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "steel_pipe_3d")));
        }
        if (stack.isOf(ModItems.CHAIR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "chair_3d")));
        }
        return value;
    }

}

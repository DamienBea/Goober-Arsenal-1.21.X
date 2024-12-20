package net.teamluxron.gooberarsenal.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.BlockStatesLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.teamluxron.gooberarsenal.GooberArsenal;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.render.model.ModelLoader;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;


@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V",
            ordinal = 1, shift = At.Shift.AFTER))

    public void loadItemModel(BlockColors blockColors, Profiler profiler, Map<Identifier,
            JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<BlockStatesLoader.SourceTrackedData>> blockStates,
                             CallbackInfo ci) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "frying_pan_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "diamond_sworded_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "bee_bunny_basher_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "stahp_sign_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "steel_pipe_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "chair_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "wooden_bat_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "golden_bat_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "iron_bat_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "diamond_bat_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(GooberArsenal.MOD_ID, "netherite_bat_3d")));
    }



}

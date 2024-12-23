package net.teamluxron.gooberarsenal.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.teamluxron.gooberarsenal.block.ModBlocks;
import net.teamluxron.gooberarsenal.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ANCIENT_CAGE);
        addDrop(ModBlocks.CAGITE_BLOCK);
        addDrop(ModBlocks.KEVIN_BLOCK);

        //ore Drops
        addDrop(ModBlocks.KEVIN_ORE, oreDrops(ModBlocks.KEVIN_ORE, ModItems.KEVIN_SHARD));
        addDrop(ModBlocks.DEEPSLATE_KEVIN_ORE, oreDrops(ModBlocks.DEEPSLATE_KEVIN_ORE, ModItems.KEVIN_SHARD));

        //Copper like ore drops
//        addDrop(ModBlocks.KEVIN_ORE, multipleOreDrops(ModBlocks.KEVIN_ORE, ModItems.KEVIN, 3, 7));
    }


    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}

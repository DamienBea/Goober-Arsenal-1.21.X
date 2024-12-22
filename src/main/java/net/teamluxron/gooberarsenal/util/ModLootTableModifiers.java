package net.teamluxron.gooberarsenal.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.item.ModItems;

import static net.minecraft.util.Identifier.isNamespaceValid;
import static net.minecraft.util.Identifier.isPathValid;

public class ModLootTableModifiers {
    private static final Identifier CHICKEN =
             Identifier.of("minecraft", "entities/chicken");
    private static final Identifier SHIPWRECK_TREASURE_CHEST =
            Identifier.of("minecraft", "chests/shipwreck_treasure");
    private static final Identifier BURIED_TREASURE_CHEST =
            Identifier.of("minecraft", "chests/buried_treasure");
    private static final Identifier BASTION_HOGLIN_STABLE_CHEST =
            Identifier.of("minecraft", "chests/bastion_hoglin_stable");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (LootTables.SHIPWRECK_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f)) // 5% chance
                        .with(ItemEntry.builder(ModItems.LIFE_SAVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
            if (LootTables.BURIED_TREASURE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.30f)) // 5% chance
                        .with(ItemEntry.builder(ModItems.LIFE_SAVER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
            if (LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.30f)) // 5% chance
                        .with(ItemEntry.builder(ModItems.RUBBER_CHICKEN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }

            if (EntityType.CHICKEN.getLootTableId().equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // 1% chance
                        .with(ItemEntry.builder(ModItems.RUBBER_CHICKEN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }}

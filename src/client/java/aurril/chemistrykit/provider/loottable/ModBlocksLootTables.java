package aurril.chemistrykit.provider.loottable;

import aurril.chemistrykit.registry.ModBlocks;
import aurril.chemistrykit.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;


public class ModBlocksLootTables extends FabricBlockLootTableProvider {
    public ModBlocksLootTables(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addSulfurBlock();
        addSulfurCluster();
        addSulfurBuds();
        addBuddingSulfur();
        addSaltPeter();
    }

    private void addSulfurBlock() {
        this.addDrop(ModBlocks.SULFUR_BLOCK, (Block block) -> {
            LootTable.Builder builder = LootTable.builder();
            LootPool.Builder poolBuilder = LootPool.builder();

            poolBuilder
                    .bonusRolls(ConstantLootNumberProvider.create(1.0f))
                    .conditionally(SurvivesExplosionLootCondition.builder())
                    .with(ItemEntry.builder(block).weight(3))
                    .with(AlternativeEntry.builder(
                            ItemEntry.builder(block)
                                    .conditionally(WITH_SILK_TOUCH),
                            ItemEntry.builder(ModItems.SULFUR_SHARD)
                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 7.0f)))
                                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                                    .weight(7)
                    ));

            builder.pool(poolBuilder)
                    .randomSequenceId(block.getLootTableId());

            return builder;
        });
    }

    private void addSulfurCluster() {
        this.addDrop(ModBlocks.SULFUR_CLUSTER, (Block block) -> {
            LootTable.Builder builder = LootTable.builder();
            LootPool.Builder poolBuilder = LootPool.builder();

            poolBuilder
                    .with(AlternativeEntry.builder(
                            ItemEntry.builder(block)
                                    .conditionally(WITH_SILK_TOUCH),
                            AlternativeEntry.builder(
                                    ItemEntry.builder(ModItems.SULFUR_SHARD)
                                            .conditionally(MatchToolLootCondition.builder(
                                                    ItemPredicate.Builder.create().tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                                            ))
                                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(9.0f)))
                                            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)),
                                    ItemEntry.builder(ModItems.SULFUR_SHARD)
                                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5.0f)))
                                            .apply(ExplosionDecayLootFunction.builder())
                            )
                    ));

            builder.pool(poolBuilder)
                    .randomSequenceId(block.getLootTableId());

            return builder;
        });
    }

    private void addSulfurBuds() {
        Block[] sulfurBuds = {
                ModBlocks.SMALL_SULFUR_BUD,
                ModBlocks.MEDIUM_SULFUR_BUD,
                ModBlocks.LARGE_SULFUR_BUD
        };

        for (Block budBlock : sulfurBuds) {
            this.addDrop(budBlock, (Block block) -> {
                LootTable.Builder builder = LootTable.builder();
                LootPool.Builder poolBuilder = LootPool.builder();

                poolBuilder
                        .conditionally(WITH_SILK_TOUCH)
                        .with(ItemEntry.builder(block));

                builder.pool(poolBuilder)
                        .randomSequenceId(block.getLootTableId());

                return builder;
            });
        }
    }

    private void addBuddingSulfur() {
        this.addDrop(
                ModBlocks.BUDDING_SULFUR_BLOCK,
                LootTable.builder()
                        .randomSequenceId(ModBlocks.BUDDING_SULFUR_BLOCK.getLootTableId())
        );
    }

    private void addSaltPeter() {
        this.addDrop(
                ModBlocks.SALTPETER, (Block block) -> {
                    LootTable.Builder builder = LootTable.builder();
                    LootPool.Builder poolBuilder = LootPool.builder();

                    poolBuilder
                            .conditionally(SurvivesExplosionLootCondition.builder())
                            .with(AlternativeEntry.builder(
                                    ItemEntry.builder(block)
                                            .conditionally(WITH_SILK_TOUCH),
                                    ItemEntry.builder(ModItems.SALTPETER_POWDER)
                                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0f)))
                                            .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                            ));

                    builder.pool(poolBuilder)
                            .randomSequenceId(block.getLootTableId());

                    return builder;
                }
        );
    }
}

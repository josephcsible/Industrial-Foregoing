package com.buuz135.industrial.proxy;

import com.buuz135.industrial.entity.EntityPinkSlime;
import com.buuz135.industrial.fluid.IFCustomFluidBlock;
import com.buuz135.industrial.proxy.client.BlockRenderRegistry;
import com.buuz135.industrial.proxy.client.FluidsRenderRegistry;
import com.buuz135.industrial.proxy.client.ItemRenderRegistry;
import com.buuz135.industrial.tile.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.ndrei.teslacorelib.TeslaCoreLib;

import java.util.Random;

public class BlockRegistry {

    public static PetrifiedFuelGeneratorBlock petrifiedFuelGeneratorBlock = new PetrifiedFuelGeneratorBlock();
    public static EnchantmentRefinerBlock enchantmentRefinerBlock = new EnchantmentRefinerBlock();
    public static EnchantmentExtractorBlock enchantmentExtractorBlock = new EnchantmentExtractorBlock();
    public static EnchantmentAplicatorBlock enchantmentAplicatorBlock = new EnchantmentAplicatorBlock();
    public static MobRelocatorBlock mobRelocatorBlock = new MobRelocatorBlock();
    public static PotionEnervatorBlock potionEnervatorBlock = new PotionEnervatorBlock();
    public static AnimalIndependenceSelectorBlock animalIndependenceSelectorBlock = new AnimalIndependenceSelectorBlock();
    public static AnimalStockIncreaserBlock animalStockIncreaserBlock = new AnimalStockIncreaserBlock();
    public static CropSowerBlock cropSowerBlock = new CropSowerBlock();
    public static CropEnrichMaterialInjectorBlock cropEnrichMaterialInjectorBlock = new CropEnrichMaterialInjectorBlock();
    public static CropRecolectorBlock cropRecolectorBlock = new CropRecolectorBlock();
    public static BlackHoleUnitBlock blackHoleUnitBlock = new BlackHoleUnitBlock();
    public static WaterCondensatorBlock waterCondensatorBlock = new WaterCondensatorBlock();
    public static WaterResourcesCollectorBlock waterResourcesCollectorBlock = new WaterResourcesCollectorBlock();
    public static AnimalResourceHarvesterBlock animalResourceHarvesterBlock = new AnimalResourceHarvesterBlock();
    public static MobSlaughterFactoryBlock mobSlaughterFactoryBlock = new MobSlaughterFactoryBlock();
    public static MobDuplicatorBlock mobDuplicatorBlock = new MobDuplicatorBlock();
    public static BlockDestroyerBlock blockDestroyerBlock = new BlockDestroyerBlock();
    public static BlockPlacerBlock blockPlacerBlock = new BlockPlacerBlock();
    public static TreeFluidExtractorBlock treeFluidExtractorBlock = new TreeFluidExtractorBlock();
    public static LatexProcessingUnitBlock latexProcessingUnitBlock = new LatexProcessingUnitBlock();
    public static SewageCompostSolidiferBlock sewageCompostSolidiferBlock = new SewageCompostSolidiferBlock();
    public static AnimalByproductRecolectorBlock animalByproductRecolectorBlock = new AnimalByproductRecolectorBlock();
    public static SludgeRefinerBlock sludgeRefinerBlock = new SludgeRefinerBlock();
    public static MobDetectorBlock mobDetectorBlock = new MobDetectorBlock();
    public static LavaFabricatorBlock lavaFabricatorBlock = new LavaFabricatorBlock();
    public static BioReactorBlock bioReactorBlock = new BioReactorBlock();
    public static BiofuelGeneratorBlock biofuelGeneratorBlock = new BiofuelGeneratorBlock();
    public static LaserBaseBlock laserBaseBlock = new LaserBaseBlock();
    public static LaserDrillBlock laserDrillBlock = new LaserDrillBlock();
    public static OreProcessorBlock oreProcessorBlock = new OreProcessorBlock();
    public static BlackHoleControllerBlock blackHoleControllerBlock = new BlackHoleControllerBlock();
    public static DyeMixerBlock dyeMixerBlock = new DyeMixerBlock();
    public static EnchantmentInvokerBlock enchantmentInvokerBlock = new EnchantmentInvokerBlock();
    public static SporesRecreatorBlock sporesRecreatorBlock = new SporesRecreatorBlock();
    public static AnimalGrowthIncreaserBlock animalGrowthIncreaserBlock = new AnimalGrowthIncreaserBlock();
    public static MaterialStoneWorkFactoryBlock materialStoneWorkFactoryBlock = new MaterialStoneWorkFactoryBlock();
    public static BlackHoleTankBlock blackHoleTankBlock = new BlackHoleTankBlock();
    public static ResourcefulFurnaceBlock resourcefulFurnaceBlock = new ResourcefulFurnaceBlock();
    public static VillagerTradeExchangerBlock villagerTradeExchangerBlock = new VillagerTradeExchangerBlock();
    public static EnergyFieldProviderBlock energyFieldProviderBlock = new EnergyFieldProviderBlock();
    public static OreDictionaryConverterBlock oreDictionaryConverterBlock = new OreDictionaryConverterBlock();
    public static ProteinReactorBlock proteinReactorBlock = new ProteinReactorBlock();
    public static ProteinGeneratorBlock proteinGeneratorBlock = new ProteinGeneratorBlock();
    public static HydratorBlock hydratorBlock = new HydratorBlock();

    public static IFCustomFluidBlock BLOCK_ESSENCE = new IFCustomFluidBlock(FluidsRegistry.ESSENCE, Material.WATER);
    public static IFCustomFluidBlock BLOCK_MILK = new IFCustomFluidBlock(FluidsRegistry.MILK, Material.WATER);
    public static IFCustomFluidBlock BLOCK_MEAT = new IFCustomFluidBlock(FluidsRegistry.MEAT, Material.WATER);
    public static IFCustomFluidBlock BLOCK_LATEX = new IFCustomFluidBlock(FluidsRegistry.LATEX, Material.WATER);
    public static IFCustomFluidBlock BLOCK_SEWAGE = new IFCustomFluidBlock(FluidsRegistry.SEWAGE, Material.LAVA);
    public static IFCustomFluidBlock BLOCK_SLUDGE = new IFCustomFluidBlock(FluidsRegistry.SLUDGE, Material.LAVA);
    public static IFCustomFluidBlock BLOCK_BIOFUEL = new IFCustomFluidBlock(FluidsRegistry.BIOFUEL, Material.WATER);
    public static IFCustomFluidBlock BLOCK_PINK_SLIME = (IFCustomFluidBlock) new IFCustomFluidBlock(FluidsRegistry.PINK_SLIME, Material.WATER) {
        @Override
        public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
            if (state.getBlock() instanceof BlockFluidClassic && ((BlockFluidClassic) state.getBlock()).isSourceBlock(worldIn, pos)) {
                worldIn.setBlockToAir(pos);
                EntityPinkSlime pinkSlime = new EntityPinkSlime(worldIn);
                pinkSlime.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                worldIn.spawnEntity(pinkSlime);
            }
        }
    }.setTickRandomly(true);
    public static IFCustomFluidBlock BLOCK_PROTEIN = new IFCustomFluidBlock(FluidsRegistry.PROTEIN, Material.WATER);

    private static ItemSplitterBlock itemSplitterBlock = new ItemSplitterBlock();

    public static void createRecipes() {
        CustomOrientedBlock.blockList.forEach(CustomOrientedBlock::createRecipe);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> ev) {
        CustomOrientedBlock.blockList.forEach(customOrientedBlock -> customOrientedBlock.registerBlock(ev.getRegistry()));
        BLOCK_ESSENCE.register(ev.getRegistry());
        BLOCK_MILK.register(ev.getRegistry());
        BLOCK_MEAT.register(ev.getRegistry());
        BLOCK_LATEX.register(ev.getRegistry());
        BLOCK_SEWAGE.register(ev.getRegistry());
        BLOCK_SLUDGE.register(ev.getRegistry());
        BLOCK_BIOFUEL.register(ev.getRegistry());
        BLOCK_PINK_SLIME.register(ev.getRegistry());
        BLOCK_PROTEIN.register(ev.getRegistry());
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> ev) {
        CustomOrientedBlock.blockList.forEach(customOrientedBlock -> customOrientedBlock.registerItem(ev.getRegistry()));
        ItemRegistry.registerItems(ev.getRegistry());
        if (TeslaCoreLib.INSTANCE.isClientSide()) {
            ItemRenderRegistry.registerRender();
            FluidsRenderRegistry.registerRender();
            BlockRenderRegistry.registerRender();
        }
    }
}

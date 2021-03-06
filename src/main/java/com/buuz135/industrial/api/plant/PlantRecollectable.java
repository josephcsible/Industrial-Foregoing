package com.buuz135.industrial.api.plant;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;

public abstract class PlantRecollectable extends IForgeRegistryEntry.Impl<PlantRecollectable> {

    public PlantRecollectable(String name) {
        setRegistryName(name);
    }

    /**
     * Checks if the Block can be harvested.
     *
     * @param world      The world where the Block is located.
     * @param pos        The position where the Block is located.
     * @param blockState The IBlockState of the Block.
     * @return True if it can be harvested, false if it can't be harvested.
     */
    public abstract boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState);

    /**
     * Harvests the block
     *
     * @param world      The world where the Block is located.
     * @param pos        The position where the Block is located.
     * @param blockState The IBlockState of the Block.
     * @return A list of the drops of that Block.
     */
    public abstract List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState);


    /**
     * Checks if the next block should be checked from the harvester.
     *
     * @param world      The world where the Block is located.
     * @param pos        The position where the Block is located.
     * @param blockState The IBlockState of the Block.
     * @return True if the harvester should check the next position or false if it should keep checking the current position.
     */
    public abstract boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState);

    /**
     * Returns the priority of the handler. The bigger it is the more priority it has.
     *
     * @return The priority.
     */
    public int getPriority() {
        return -1;
    }
}

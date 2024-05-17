
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.nxroads.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.nxroads.block.entity.RoadCraftingTableBlockEntity;
import net.mcreator.nxroads.NxRoadsAndSkycrapersMod;

public class NxRoadsAndSkycrapersModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NxRoadsAndSkycrapersMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ROAD_CRAFTING_TABLE = register("road_crafting_table", NxRoadsAndSkycrapersModBlocks.ROAD_CRAFTING_TABLE, RoadCraftingTableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

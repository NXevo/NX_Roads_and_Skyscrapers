
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.nxroads.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.nxroads.world.inventory.RoadTableMenu;
import net.mcreator.nxroads.NxRoadsAndSkycrapersMod;

public class NxRoadsAndSkycrapersModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NxRoadsAndSkycrapersMod.MODID);
	public static final RegistryObject<MenuType<RoadTableMenu>> ROAD_TABLE = REGISTRY.register("road_table", () -> IForgeMenuType.create(RoadTableMenu::new));
}

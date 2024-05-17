
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.nxroads.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.nxroads.client.gui.RoadTableScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NxRoadsAndSkycrapersModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(NxRoadsAndSkycrapersModMenus.ROAD_TABLE.get(), RoadTableScreen::new);
		});
	}
}

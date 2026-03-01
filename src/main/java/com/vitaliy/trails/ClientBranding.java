package com.vitaliy.trails;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientBranding {

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        System.setProperty("forge.brand", "streamertrails");
    }
}

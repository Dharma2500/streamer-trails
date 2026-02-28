package com.vitaliy.trails;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;
        if (!event.player.world.isRemote) return;

        PlayerEntity player = event.player;

        if (player.getMotion().length() > 0.05) {
            player.world.addParticle(
                    net.minecraft.particles.ParticleTypes.END_ROD,
                    player.getPosX(),
                    player.getPosY() + 0.1,
                    player.getPosZ(),
                    0, 0, 0
            );
        }
    }
}
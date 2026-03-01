package com.vitaliy.trails;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;

        for (PlayerEntity player : mc.level.players()) {

            if (!player.isAlive()) continue;

            // Только если игрок движется
            if (player.getDeltaMovement().lengthSqr() < 0.001) continue;

            float size = 1.0F;

            // Твой ник — больше размер
            if (player.getName().getString().equals("Vitaly_Sokolov")) {
                size = 1.8F;
            }

            float r = ModConfigHolder.RED.get().floatValue();
            float g = ModConfigHolder.GREEN.get().floatValue();
            float b = ModConfigHolder.BLUE.get().floatValue();

            // Красивый шлейф
            for (int i = 0; i < 4; i++) {

                double offsetX = (mc.level.random.nextDouble() - 0.5) * 0.4;
                double offsetZ = (mc.level.random.nextDouble() - 0.5) * 0.4;

                mc.level.addParticle(
                        new RedstoneParticleData(r, g, b, size),
                        player.getX() + offsetX,
                        player.getY() + 0.1,
                        player.getZ() + offsetZ,
                        0, 0, 0
                );
            }
        }
    }
}

package com.vitaliy.trails;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        PlayerEntity player = event.player;
        World world = player.level; // official mapping

        if (!world.isClientSide) return;

        Vector3d motion = player.getDeltaMovement(); // official mapping

        if (motion.length() > 0.05) {

            world.addParticle(
                    net.minecraft.particles.ParticleTypes.END_ROD,
                    player.getX(),
                    player.getY() + 0.1,
                    player.getZ(),
                    0, 0, 0
            );
        }
    }
}

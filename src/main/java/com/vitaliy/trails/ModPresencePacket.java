package com.vitaliy.trails;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class ModPresencePacket {

    public static void encode(ModPresencePacket msg, PacketBuffer buf) {}

    public static ModPresencePacket decode(PacketBuffer buf) {
        return new ModPresencePacket();
    }

    public static void handle(ModPresencePacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity sender = ctx.get().getSender();
            if (sender != null) {
                PlayerTracker.addPlayer(sender.getUUID());
            }
        });
        ctx.get().setPacketHandled(true);
    }
}

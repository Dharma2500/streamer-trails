package com.vitaliy.trails;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerTracker {

    private static final Set<UUID> PLAYERS_WITH_MOD = new HashSet<>();

    public static void addPlayer(UUID uuid) {
        PLAYERS_WITH_MOD.add(uuid);
    }

    public static boolean hasMod(UUID uuid) {
        return PLAYERS_WITH_MOD.contains(uuid);
    }
}

package com.narxoz.rpg.combatant;

import com.narxoz.rpg.artifact.Artifact;
import java.util.List;

/**
 * Immutable snapshot of a hero's mutable state.
 *
 * This class intentionally lives next to {@link Hero} so the originator can
 * restore itself without exposing internals to other packages.
 */
public final class HeroMemento {

    private final int hp;
    private final int mana;
    private final int gold;
    private final List<Artifact> inventorySnapshot;

    HeroMemento(int hp,
                int mana,
                int gold,
                List<Artifact> inventorySnapshot) {
        this.hp = hp;
        this.mana = mana;
        this.gold = gold;
        this.inventorySnapshot = inventorySnapshot == null ? List.of() : List.copyOf(inventorySnapshot);
    }

    int getHp() {
        return hp;
    }

    int getMana() {
        return mana;
    }

    int getGold() {
        return gold;
    }

    List<Artifact> getInventorySnapshot() {
        return inventorySnapshot;
    }
}

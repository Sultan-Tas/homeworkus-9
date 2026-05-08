package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.*;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.printf("► This [%s] magically enhances your attack by [%d] dmg %n", weapon.getName(), weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.printf("► This [%s] magically heals you by [%d] hp %n", potion.getName(), potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.printf("► This [%s] magically applies [%s] to you %n", scroll.getName(), scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.printf("► This [%s] magically enhances you by [%d] points %n", ring.getName(), ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.printf("► This [%s] magically protects you by [%d] def %n", armor.getName(), armor.getDefenseBonus());
    }
}

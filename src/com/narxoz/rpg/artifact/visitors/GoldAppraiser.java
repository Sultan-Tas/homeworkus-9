package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {
    public String getName(){
        return "Gold Appraiser";
    }
    @Override
    public void visit(Weapon weapon) {
        System.out.printf("☼ The weapon [%s] is worth %d gold%n", weapon.getName(), weapon.getValue());
    }

    @Override
    public void visit(Potion potion) {
        System.out.printf("☼ The potion [%s] is worth %d gold%n", potion.getName(), potion.getValue());

    }

    @Override
    public void visit(Scroll scroll) {
        System.out.printf("☼ The scroll [%s] is worth %d gold%n", scroll.getName(), scroll.getValue());
    }

    @Override
    public void visit(Ring ring) {
        System.out.printf("☼ The ring [%s] is worth %d gold%n", ring.getName(), ring.getValue());
    }

    @Override
    public void visit(Armor armor) {
        System.out.printf("☼ The armor [%s] is worth %d gold%n", armor.getName(), armor.getValue());
    }
}

package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.*;

public class WeightCalculator implements ArtifactVisitor {
    public String getName(){
        return "Weight Calculator";
    }
    @Override
    public void visit(Weapon weapon) {
        System.out.printf("↓ The weapon %s weighs total of %d units %n", weapon.getName(), weapon.getWeight());
    }

    @Override
    public void visit(Potion potion) {
        System.out.printf("↓ The potion %s weighs total of %d units %n", potion.getName(), potion.getWeight());
    }
    @Override
    public void visit(Scroll scroll) {
        System.out.printf("↓ The scroll %s weighs total of %d units %n", scroll.getName(), scroll.getWeight());
    }

    @Override
    public void visit(Ring ring) {
        System.out.printf("↓ The ring %s weighs total of %d units %n", ring.getName(), ring.getWeight());
    }

    @Override
    public void visit(Armor armor) {
        System.out.printf("↓ The armor %s weighs total of %d units %n", armor.getName(), armor.getWeight());
    }
}

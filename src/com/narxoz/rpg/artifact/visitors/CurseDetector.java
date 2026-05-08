package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        if (weapon.getName().toLowerCase().contains("cursed")){
            System.out.printf("The weapon %s is cursed!", weapon.getName());
        }
        else{
            System.out.printf("The weapon %s does not have any curses", weapon.getName());
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getName().toLowerCase().contains("cursed")){
            System.out.printf("The potion %s is cursed!", potion.getName());
        }
        else{
            System.out.printf("The potion %s does not have any curses", potion.getName());
        }
    }
    @Override
    public void visit(Scroll scroll) {
        if (scroll.getName().toLowerCase().contains("cursed")){
            System.out.printf("The scroll %s is cursed!", scroll.getName());
        }
        else{
            System.out.printf("The scroll %s does not have any curses", scroll.getName());
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getName().toLowerCase().contains("cursed")){
            System.out.printf("The ring %s is cursed!", ring.getName());
        }
        else{
            System.out.printf("The ring %s does not have any curses", ring.getName());
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getName().toLowerCase().contains("cursed")){
            System.out.printf("The armor %s is cursed!", armor.getName());
        }
        else{
            System.out.printf("The armor %s does not have any curses", armor.getName());
        }
    }
}

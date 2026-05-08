package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {
    public String getName(){
        return "Curse Detector";
    }
    @Override
    public void visit(Weapon weapon) {
        if (weapon.getName().toLowerCase().contains("cursed")){
            System.out.printf("§ The weapon %s is cursed! %n", weapon.getName());
        }
        else{
            System.out.printf("§ The weapon %s does not have any curses %n", weapon.getName());
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getName().toLowerCase().contains("cursed")){
            System.out.printf("§ The potion %s is cursed! %n", potion.getName());
        }
        else{
            System.out.printf("§ The potion %s does not have any curses %n", potion.getName());
        }
    }
    @Override
    public void visit(Scroll scroll) {
        if (scroll.getName().toLowerCase().contains("cursed")){
            System.out.printf("§ The scroll %s is cursed! %n", scroll.getName());
        }
        else{
            System.out.printf("§ The scroll %s does not have any curses %n", scroll.getName());
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getName().toLowerCase().contains("cursed")){
            System.out.printf("§ The ring %s is cursed! %n", ring.getName());
        }
        else{
            System.out.printf("§ The ring %s does not have any curses %n", ring.getName());
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getName().toLowerCase().contains("cursed")){
            System.out.printf("§ The armor %s is cursed! %n", armor.getName());
        }
        else{
            System.out.printf("§ The armor %s does not have any curses %n", armor.getName());
        }
    }
}

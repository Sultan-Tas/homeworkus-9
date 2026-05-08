package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.artifact.visitors.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.memento.CaretakerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        int appraisedArtifacts = 0;
        int mementosCreated = 0;
        int restoreCount = 0;

        Hero firstHero = party.getFirst();
        Hero lastHero = party.getLast();
        Random random = new Random();
        System.out.println("\tVisitor Demonstration:");

        //setting up artifacts and heroes' inventory
        Artifact knife = new Weapon("Combat Knife", 20, 5, 15);
        Artifact liberTea = new Potion("Liber-Tea", 99, 5, 100);
        Artifact ringDemocrat = new Ring("Ring of Democracy", 250, 3, 40);
        Artifact evilTech = new Armor("Cursed Automaton Armor", 20, 50, 90);
        Artifact liberator = new Weapon("Liberator MG-32", 50, 20, 50);

        //adding artifacts to the first hero
        firstHero.getInventory().addArtifact(knife);
        firstHero.getInventory().addArtifact(liberTea);
        firstHero.getInventory().addArtifact(evilTech);
        System.out.println("Added " + firstHero.getInventory().size() +  " artifacts to " + firstHero.getName());

        //adding artifacts to the last hero
        lastHero.getInventory().addArtifact(liberator);
        lastHero.getInventory().addArtifact(ringDemocrat);
        lastHero.getInventory().addArtifact(liberTea);
        System.out.println("Added " + lastHero.getInventory().size() + " artifacts to " + lastHero.getName());

        //setting up visitors
        ArtifactVisitor goldAppraiser = VisitorFactory.create(VisitorType.GOLD_APPRAISER);
        ArtifactVisitor enchantmentScan = VisitorFactory.create(VisitorType.ENCHANTMENT_SCANNER);
        ArtifactVisitor curseScan = VisitorFactory.create(VisitorType.CURSE_DETECTOR);
        ArtifactVisitor weightScan = VisitorFactory.create(VisitorType.WEIGHT_CALC);
        //list of visitors
        List<ArtifactVisitor> visitors = new ArrayList<>();
        visitors.add(goldAppraiser);
        visitors.add(enchantmentScan);
        visitors.add(curseScan);
        visitors.add(weightScan);

        //visiting 1st hero
        System.out.println("Demonstrating usage of Visitors");
        System.out.println("First Hero");
        for(ArtifactVisitor visitor : visitors) {
            System.out.println("\n\t" + visitor.getName());
            firstHero.getInventory().accept(visitor);
            appraisedArtifacts += lastHero.getInventory().size();
        }
        System.out.println();
        //visiting 2nd hero
        System.out.print("Second Hero");
        for(ArtifactVisitor visitor : visitors) {
            System.out.println("\n\t" + visitor.getName());
            lastHero.getInventory().accept(visitor);
            appraisedArtifacts += lastHero.getInventory().size();
        }


        System.out.println("\n\n Memento demonstration:");
        //creating memento
        System.out.println("\nCreating memento");
        Caretaker saves = CaretakerFactory.createCaretaker();
        saves.save(firstHero.createMemento());
        mementosCreated++;

        //before changes
        System.out.println("\n\tHero stats before change");
        System.out.println(firstHero);
        System.out.println("Inventory:");
        for(Artifact item : firstHero.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }

        //applying changes
        firstHero.takeDamage(random.nextInt(1000));
        firstHero.addGold(random.nextInt(500));
        firstHero.restoreMana(random.nextInt(200));
        firstHero.getInventory().deleteLastArtifact();
        firstHero.getInventory().deleteLastArtifact();
        firstHero.getInventory().addArtifact(liberator);
        System.out.println("\n\tModified Hero's state:");
        System.out.println(firstHero);
        System.out.println("Inventory:");
        for(Artifact item : firstHero.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }

        //process of rewinding
        firstHero.restoreFromMemento(saves.undo());
        restoreCount++;

        //restored state from memento
        System.out.println("\n\tRestored Hero's state:");
        System.out.println(firstHero);
        System.out.println("Inventory:");
        for(Artifact item : firstHero.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }
        return new VaultRunResult(appraisedArtifacts, mementosCreated, restoreCount);
    }
}

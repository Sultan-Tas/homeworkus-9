package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.artifact.visitors.CurseDetector;
import com.narxoz.rpg.artifact.visitors.EnchantmentScanner;
import com.narxoz.rpg.artifact.visitors.GoldAppraiser;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for Homework 9 — Chronomancer's Vault: Visitor + Memento.
 *
 * The scaffold prints the banner only; students fill in the vault demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");
        System.out.println("\tVisitor Demonstration:");
        //Creating 2 different heroes
        Hero John = new Hero("John Helldiver", 1000, 190, 150);
        Hero Brasch = new Hero("General Brasch", 750, 250, 100);

        //setting up artifacts and heroes' inventory
        Artifact knife = new Weapon("Combat Knife", 20, 5, 15);
        Artifact liberTea = new Potion("Liber-Tea", 99, 5, 100);
        Artifact ringDemocrat = new Ring("Ring of Democracy", 250, 3, 40);
        Artifact evilTech = new Armor("Cursed Automaton Armor", 20, 50, 90);
        Artifact liberator = new Weapon("Liberator MG-32", 50, 20, 50);

        John.getInventory().addArtifact(knife);
        John.getInventory().addArtifact(liberTea);
        John.getInventory().addArtifact(evilTech);
        System.out.println("Added 3 artifacts to John");

        Brasch.getInventory().addArtifact(liberator);
        Brasch.getInventory().addArtifact(ringDemocrat);
        Brasch.getInventory().addArtifact(liberTea);
        System.out.println("Added 3 artifacts to Brasch");

        //setting up visitors
        ArtifactVisitor goldAppraiser = new GoldAppraiser();
        ArtifactVisitor enchantmentScan = new EnchantmentScanner();
        ArtifactVisitor curseScan = new CurseDetector();

        System.out.println("Demonstrating usage of Visitors");
        System.out.println("\n\tGold Appraiser:");
        John.getInventory().accept(goldAppraiser);
        System.out.println("\n\tEnchantment scan:");
        John.getInventory().accept(enchantmentScan);;
        System.out.println("\n\tCurse scan:");
        John.getInventory().accept(curseScan);

        System.out.println("\n\tGold Appraiser:");
        Brasch.getInventory().accept(goldAppraiser);
        System.out.println("\n\tEnchantment scan:");
        Brasch.getInventory().accept(enchantmentScan);
        System.out.println("\n\tCurse scan:");
        Brasch.getInventory().accept(curseScan);


        System.out.println("\n\n Memento demonstration:");
        //creating memento
        Caretaker saves = new Caretaker();
        saves.save(John.createMemento());
        //before changes
        System.out.println(John);
        System.out.println("Inventory:");
        for(Artifact item : John.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }

        //applying changes
        John.takeDamage(478);
        John.addGold(123);
        John.restoreMana(286);
        John.getInventory().deleteLastArtifact();
        John.getInventory().deleteLastArtifact();
        John.getInventory().addArtifact(liberator);
        System.out.println("\n\tModified Hero's state:");
        System.out.println(John);
        System.out.println("Inventory:");
        for(Artifact item : John.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }

        //process of rewinding
        John.restoreFromMemento(saves.undo());

        //restored state from memento
        System.out.println("\n\tRestored Hero's state:");
        System.out.println(John);
        System.out.println("Inventory:");
        for(Artifact item : John.getInventory().getArtifacts()) {
            System.out.println("\t" + item.getName());
        }

        System.out.println("\n\n== Running ChronomancerEngine Demo ==");
        //creating engine object
        ChronomancerEngine engine = new ChronomancerEngine();
        //creating party
        List<Hero> party = new ArrayList<Hero>();
        party.add(John);
        party.add(Brasch);
        //running the engine
        VaultRunResult result = engine.runVault(party);
        System.out.println(result);
    }
}

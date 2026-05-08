package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

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
        //Creating 2 different heroes
        Hero John = new Hero("John Helldiver", 1000, 190, 150);
        Hero Brasch = new Hero("General Brasch", 750, 250, 100);


        System.out.println("\n\n== Running ChronomancerEngine Demo ==");
        //creating engine object
        ChronomancerEngine engine = new ChronomancerEngine();
        //creating party
        List<Hero> party = new ArrayList<Hero>();
        party.add(John);
        party.add(Brasch);
        //running the engine
        VaultRunResult result = engine.runVault(party);
        System.out.println();
        System.out.println(result);
    }
}

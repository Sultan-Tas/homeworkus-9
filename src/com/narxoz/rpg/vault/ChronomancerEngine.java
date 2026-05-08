package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.visitors.CurseDetector;
import com.narxoz.rpg.artifact.visitors.EnchantmentScanner;
import com.narxoz.rpg.artifact.visitors.GoldAppraiser;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.memento.CaretakerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        int artifactsAppraised = 0;
        int mementosCreated = 0;
        int restoredCount = 0;

        //setting up visitors
        ArtifactVisitor goldAppraiser = new GoldAppraiser();
        ArtifactVisitor enchantmentScan = new EnchantmentScanner();
        ArtifactVisitor curseScan = new CurseDetector();

        List<Caretaker> caretakers = new ArrayList<>();
        for(Hero hero : party) {
            caretakers.add(CaretakerFactory.createCaretaker());
        }

        return new VaultRunResult(0, 0, 0);
    }

    private static boolean isPartyAlive(List<Hero> party) {
        return false;
    }
}

package com.narxoz.rpg.artifact.visitors;

import com.narxoz.rpg.artifact.ArtifactVisitor;

public class VisitorFactory {

    public static ArtifactVisitor create(VisitorType type) {
        return switch (type) {
            case CURSE_DETECTOR -> new CurseDetector();
            case ENCHANTMENT_SCANNER -> new EnchantmentScanner();
            case GOLD_APPRAISER -> new GoldAppraiser();
            case WEIGHT_CALC -> new WeightCalculator();
            default -> throw new IllegalArgumentException("Unknown visitor type: " + type);
        };
    }
}

package com.unitconverter.model;

public enum WeightUnit {
    KILOGRAM(1.0, "kg"),
    GRAM(0.001, "g"),
    MILLIGRAM(0.000001, "mg"),
    OUNCE(0.0283, "oz"),
    POUND(0.4536, "lb");

    private final double multiplierInKilograms;
    private final String symbol;

    WeightUnit(double multiplierInKilograms, String symbol) {
        this.multiplierInKilograms = multiplierInKilograms;
        this.symbol = symbol;
    }

    public double getMultiplierInKilograms() {
        return multiplierInKilograms;
    }

    public static WeightUnit fromSymbol(String symbolCode) {
        for (WeightUnit unit : values()) {
            if (unit.symbol.equalsIgnoreCase(symbolCode)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + symbolCode);
    }
}

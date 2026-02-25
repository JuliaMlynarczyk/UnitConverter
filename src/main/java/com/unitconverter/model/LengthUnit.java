package com.unitconverter.model;

public enum LengthUnit {
    METER(1.0, "m"),
    KILOMETER(1000.0, "km"),
    CENTIMETER(0.01, "cm"),
    MILLIMETER(.001, "mm"),
    INCH(0.0254, "in"),
    FOOT(0.3048, "ft"),
    YARD(0.9144, "yd"),
    MILE(16109.344, "mi");

    private final double multiplierInMeters;
    private final String symbol;

    LengthUnit(double multiplierInMeters, String symbol) {
        this.multiplierInMeters = multiplierInMeters;
        this.symbol = symbol;
    }

    public double getMultiplierInMeters() {
        return multiplierInMeters;
    }

    public String getSymbol() {
        return symbol;
    }

    public static LengthUnit fromSymbol(String symbolCode) {
        for (LengthUnit unit : values()) {
            if (unit.symbol.equalsIgnoreCase(symbolCode)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + symbolCode);
    }
}

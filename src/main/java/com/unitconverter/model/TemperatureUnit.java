package com.unitconverter.model;

public enum TemperatureUnit {
    KELVIN("k") {
        public double toBase(double value) {return (value - 273.15);}
        public double fromBase(double value) {return (value + 273.15);}
    },
    CELSIUS("c") {
        public double toBase(double value) {return value;}
        public double fromBase(double value) {return value;}
    },
    FAHRENHEIT("f") {
        public double toBase(double value) {return (value - 32) * 5 / 9;}
        public double fromBase(double value) {return (value * ((double) 9 / 5)) + 32;}
    };

    private final String symbol;

    TemperatureUnit(String symbol) {
        this.symbol = symbol;
    }

    public abstract double toBase(double value);
    public abstract double fromBase(double value);

    public static TemperatureUnit fromSymbol(String symbolCode) {
        for (TemperatureUnit unit : values()) {
            if (unit.symbol.equalsIgnoreCase(symbolCode)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + symbolCode);
    }
}

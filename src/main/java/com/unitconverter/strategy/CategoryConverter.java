package com.unitconverter.strategy;

public interface CategoryConverter {
    double convert(double value, String fromUnit, String toUnit);
    String getCategoryName();
}

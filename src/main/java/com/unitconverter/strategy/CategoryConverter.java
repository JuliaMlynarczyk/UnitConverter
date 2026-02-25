package com.unitconverter.service;

public interface CategoryConverter {
    double convert(double value, String fromUnit, String toUnit);
    String getCategoryName();
}

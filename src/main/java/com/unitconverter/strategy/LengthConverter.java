package com.unitconverter.strategy;

import com.unitconverter.model.LengthUnit;
import org.springframework.stereotype.Component;

@Component
public class LengthConverter implements CategoryConverter{

    @Override
    public double convert(double value, String fromUnit, String toUnit) {
        LengthUnit from = LengthUnit.fromSymbol(fromUnit);
        LengthUnit to = LengthUnit.fromSymbol(toUnit);

        double valueInMeters = value * from.getMultiplierInMeters();
        return valueInMeters / to.getMultiplierInMeters();
    }

    @Override
    public String getCategoryName() {
        return "length";
    }
}

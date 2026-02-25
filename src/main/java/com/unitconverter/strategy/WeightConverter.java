package com.unitconverter.strategy;

import com.unitconverter.model.WeightUnit;
import org.springframework.stereotype.Component;

@Component
public class WeightConverter implements CategoryConverter {

    @Override
    public double convert(double value, String fromUnit, String toUnit) {
        WeightUnit from = WeightUnit.fromSymbol(fromUnit);
        WeightUnit to = WeightUnit.fromSymbol(toUnit);

        double valueInKilo = value * from.getMultiplierInKilograms();
        return valueInKilo / to.getMultiplierInKilograms();
    }

    @Override
    public String getCategoryName() {
        return "weight";
    }
}

package com.unitconverter.strategy;

import com.unitconverter.model.TemperatureUnit;
import org.springframework.stereotype.Component;

@Component
public class TemperatureConverter implements CategoryConverter {

    @Override
    public double convert(double value, String fromUnit, String toUnit) {
        TemperatureUnit from = TemperatureUnit.fromSymbol(fromUnit);
        TemperatureUnit to = TemperatureUnit.fromSymbol(toUnit);

        double valueInCelsius = from.toBase(value);
        return to.fromBase(valueInCelsius);
    }

    @Override
    public String getCategoryName() {
        return "temperature";
    }
}

package com.unitconverter.service;

import com.unitconverter.strategy.CategoryConverter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConversionService {
    private final List<CategoryConverter> converters;

    public ConversionService(List<CategoryConverter> converters) {
        this.converters = converters;
    }

    public double convert(String category, double value, String fromUnit, String toUnit) {
        CategoryConverter activeConverter = converters.stream()
                .filter(c -> c.getCategoryName().equalsIgnoreCase(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Category " + category + " not found"));

        return activeConverter.convert(value, fromUnit, toUnit);
    }
}

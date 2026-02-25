package com.unitconverter.controller;

import com.unitconverter.service.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    private final ConversionService conversionService;

    public ConverterController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/convert")
    public String performConversion(
            @RequestParam("fnumber") double value,
            @RequestParam("units_from") String fromUnit,
            @RequestParam("units_to") String toUnit,
            @RequestParam("category") String category,
            Model model
    ) {
        try {
            double result = conversionService.convert(category, value, fromUnit, toUnit);
            model.addAttribute("originalValue", value);
            model.addAttribute("fromUnit", fromUnit);
            model.addAttribute("toUnit", toUnit);
            model.addAttribute("result", result);

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error: " + e.getMessage());
        }

        return "index";
    }
}
package org.ivy.structured.controller;

import org.ivy.structured.service.NumberExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
public class NumberExtractorController {
    private final NumberExtractor numberExtractor;

    public NumberExtractorController(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }

    @GetMapping("/int")
    public int extractInt(String prompt) {
        return numberExtractor.extractInt(prompt);
    }

    @GetMapping("/integer")
    public BigInteger extractInteger(String prompt) {
        return numberExtractor.extractBigInteger(prompt);
    }

    @GetMapping("/float")
    public float extractFloat(String prompt) {
        return numberExtractor.extractFloat(prompt);
    }

    @GetMapping("/double")
    public double extractDouble(String prompt) {
        return numberExtractor.extractDouble(prompt);
    }

    @GetMapping("/long")
    public long extractLong(String prompt) {
        return numberExtractor.extractLong(prompt);
    }

    @GetMapping("/bigDecimal")
    public BigDecimal extractBigDecimal (String prompt) {
        return numberExtractor.extractBigDecimal(prompt);
    }
}

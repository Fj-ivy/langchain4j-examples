package org.ivy.structured.controller;

import org.ivy.structured.service.DateTimeExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class DateTimeExtractorController {
    private final DateTimeExtractor dateTimeExtractor;

    public DateTimeExtractorController(DateTimeExtractor dateTimeExtractor) {
        this.dateTimeExtractor = dateTimeExtractor;
    }

    @GetMapping("/extract-date")
    public LocalDate extractDate(String prompt) {
        return dateTimeExtractor.extractDate(prompt);
    }

    @GetMapping("/extract-time")
    public LocalTime extractTime(String prompt) {
        return dateTimeExtractor.extractTime(prompt);
    }

    @GetMapping("/extract-datetime")
    public LocalDateTime extractDateTime(String prompt) {
        return dateTimeExtractor.extractDateTime(prompt);
    }
}

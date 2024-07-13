package org.ivy.structured.controller;

import org.ivy.structured.service.SentimentAnalyzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentimentController {

    private SentimentAnalyzer sentimentAnalyzer;

    public SentimentController(SentimentAnalyzer sentimentAnalyzer) {
        this.sentimentAnalyzer = sentimentAnalyzer;
    }

    @GetMapping("/boolean")
    public boolean isPositive(String prompt) {
        return sentimentAnalyzer.isPositive(prompt);
    }

    @GetMapping("/enum")
    public SentimentAnalyzer.Sentiment sentimentOf(String prompt) {
        return sentimentAnalyzer.analyzeSentimentOf(prompt);
    }
}

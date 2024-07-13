package org.ivy.structured.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface SentimentAnalyzer {
    @UserMessage("Does {{it}} have positive sentiment?")
    boolean isPositive(String text);

    @UserMessage("Analyze sentiment of {{it}}")
    Sentiment analyzeSentimentOf(String text);

    enum Sentiment {
        POSITIVE, NEGATIVE, NEUTRAL
    }
}


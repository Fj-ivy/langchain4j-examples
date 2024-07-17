package org.ivy.classification.example;

import org.ivy.classification.enums.Sentiment;

import java.util.List;
import java.util.Map;

public class SentimentExamples {
    public static final Map<Sentiment, List<String>> examples = Map.of(
            Sentiment.POSITIVE, List.of("This is great!", "Wow, awesome!"),
            Sentiment.NEUTRAL, List.of("Well, it's fine", "It's ok"),
            Sentiment.NEGATIVE, List.of("It is pretty bad", "Worst experience ever!")
    );
}

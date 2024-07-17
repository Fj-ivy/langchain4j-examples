package org.ivy.classification.service;

import dev.langchain4j.classification.EmbeddingModelTextClassifier;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import lombok.RequiredArgsConstructor;
import org.ivy.classification.enums.CustomerServiceCategory;
import org.ivy.classification.enums.Sentiment;
import org.ivy.classification.example.ClassifyExamples;
import org.ivy.classification.example.SentimentExamples;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassifyService {
    private final OllamaEmbeddingModel ollamaEmbeddingModel;

    /**
     * 客户服务分类
     *
     * @param text 文本
     * @return 分类列表
     */
    public List<CustomerServiceCategory> classify(String text) {
        EmbeddingModelTextClassifier<CustomerServiceCategory> classifier =
                new EmbeddingModelTextClassifier<>(ollamaEmbeddingModel, ClassifyExamples.getExamples());
        return classifier.classify(text);
    }

    /**
     * 情感分析
     *
     * @param text 文本
     * @return 分类列表
     */
    public List<Sentiment> classifySentiment(String text) {
        EmbeddingModelTextClassifier<Sentiment> classifier =
                new EmbeddingModelTextClassifier<>(ollamaEmbeddingModel, SentimentExamples.examples);
        return classifier.classify(text);
    }
}

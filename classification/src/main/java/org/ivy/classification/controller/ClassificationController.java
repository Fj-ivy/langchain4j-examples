package org.ivy.classification.controller;

import lombok.RequiredArgsConstructor;
import org.ivy.classification.enums.CustomerServiceCategory;
import org.ivy.classification.enums.Sentiment;
import org.ivy.classification.service.ClassifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/classify/")
@RequiredArgsConstructor
public class ClassificationController {
    private final ClassifyService classificationService;

    @GetMapping("/sentiment")
    public List<Sentiment> sentiment(String text) {
        return classificationService.classifySentiment(text);
    }

    @GetMapping("/service")
    public List<CustomerServiceCategory> classify(String text) {
        return classificationService.classify(text);
    }
}

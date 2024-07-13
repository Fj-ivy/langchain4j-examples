package org.ivy.structured.controller;

import dev.langchain4j.service.Result;
import org.ivy.structured.service.ResultExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    private final ResultExtractor resultExtractor;

    public ResultController(ResultExtractor resultExtractor) {
        this.resultExtractor = resultExtractor;
    }

    @GetMapping(value = "film", produces = "application/json")
    public ResultExtractor.Film extractResult(String prompt) {
        Result<ResultExtractor.Film> result =
                resultExtractor.film(new ResultExtractor.FilmPrompt(prompt));
        return result.content();
    }
}

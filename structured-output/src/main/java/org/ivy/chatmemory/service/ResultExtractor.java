package org.ivy.chatmemory.service;

import dev.langchain4j.model.input.structured.StructuredPrompt;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.spring.AiService;
import lombok.*;

import java.time.LocalDate;

@AiService
public interface ResultExtractor {

    Result<Film> film(FilmPrompt prompt);

    // ====================================== 查询某个导演最受欢迎的电影，返回电影信息 ==================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @StructuredPrompt("请问{{director}}导演最受欢迎的电影是什么？哪年发行的，电影讲述的什么内容？")
    class FilmPrompt {
        private String director;
    }

    @Data
    class Film {
        private String title;
        private String director;
        private LocalDate publicationDate;
        private String description;
    }
}

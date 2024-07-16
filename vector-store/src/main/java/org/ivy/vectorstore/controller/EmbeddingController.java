package org.ivy.vectorstore.controller;

import dev.langchain4j.data.segment.TextSegment;
import lombok.RequiredArgsConstructor;
import org.ivy.vectorstore.store.VectorStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmbeddingController {

    private final VectorStoreService vectorStoreService;

    @PostMapping("/embed")
    public String embed(@RequestBody String text) {
        return vectorStoreService.embedding(text);
    }

    @PostMapping("/embed-meta")
    public String embedMeta(@RequestBody String text) {
        return vectorStoreService.embeddingWithMeta(text);
    }

    @GetMapping("/search")
    public List<String> search(String text) {
        return vectorStoreService.search(text);
    }
}

package org.ivy.easyrag;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import lombok.RequiredArgsConstructor;
import org.ivy.easyrag.assist.Assistant;
import org.ivy.easyrag.embedding.EmbeddingService;
import org.ivy.easyrag.loaders.LoaderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EasyRagController {
    private final OpenAiChatModel openAiChatModel;
    private final EmbeddingStore<TextSegment> embeddingStore;
    private final EmbeddingService embeddingService;
    private final LoaderService loaderService;

    @GetMapping("/chat")
    public String chat(String message) {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
                .build();
        return assistant.chat(message);
    }

    @GetMapping("/embedded")
    public void embedded() {
        List<Document> documents = loaderService.loadFromFileSystem(
                "/Users/fangjie33/Documents/GitHub/langchain4j-examples/easy-rag/src/main/resources/file");
        embeddingService.embed(documents);
    }
}

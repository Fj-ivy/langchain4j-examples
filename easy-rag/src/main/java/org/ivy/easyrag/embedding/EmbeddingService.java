package org.ivy.easyrag.embedding;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmbeddingService {
    private final EmbeddingStore<TextSegment> embeddingStore;

    public void embed(List<Document> documents) {
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);
    }
}

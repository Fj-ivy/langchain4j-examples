package org.ivy.vectorstore.store;

import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.filter.Filter;
import dev.langchain4j.store.embedding.filter.MetadataFilterBuilder;
import dev.langchain4j.store.embedding.filter.comparison.IsEqualTo;
import dev.langchain4j.store.embedding.filter.comparison.IsGreaterThan;
import dev.langchain4j.store.embedding.filter.comparison.IsIn;
import dev.langchain4j.store.embedding.milvus.MilvusEmbeddingStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VectorStoreService {
    private final EmbeddingModel embeddingModel;
    private final MilvusEmbeddingStore milvusEmbeddingStore;

    /**
     * 仅存储了向量，没有原文本和元数据信息
     *
     * @param text 要嵌入的文本
     * @return 生成ID
     */
    public String embedding(String text) {
        Response<Embedding> embed = embeddingModel.embed(text);
        return milvusEmbeddingStore.add(embed.content());
    }

    /**
     * 带有元数据的方式
     *
     * @param text 要嵌入的文本
     * @return 生成ID
     */
    public String embeddingWithMeta(String text) {
        TextSegment textSegment = TextSegment.from(text, Metadata.from("userId", "1"));
        Response<Embedding> embed = embeddingModel.embed(textSegment);
        return milvusEmbeddingStore.add(embed.content(), textSegment);
    }

    public List<String> search(String query) {
        Embedding queryEmbedding = embeddingModel.embed(query).content();

        new IsIn("userId", List.of("1", "2","3"));
//        Filter filter = MetadataFilterBuilder.metadataKey("userId").isEqualTo("1");
        EmbeddingSearchRequest request = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding) // 相似性搜索文本
                .filter(new IsEqualTo("userId", "1"))
                .minScore(0.6)
                .build();
        EmbeddingSearchResult<TextSegment> result = milvusEmbeddingStore.search(request);
        return result.matches().stream().map(r-> r.embedded().text()).collect(Collectors.toList());
    }
}

package org.ivy.loaders;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

public class UrlDocumentLoaderTest implements WithAssertions {
    @Test
    public void should_load_text_document_from_url() {
        String url = "https://raw.githubusercontent.com/langchain4j/langchain4j/main/langchain4j/src/test/resources/test-file-utf8.txt";
        Document document = UrlDocumentLoader.load(url, new TextDocumentParser());
        assertThat(document.text()).isEqualTo("test\ncontent");
        assertThat(document.metadata().getString("url")).isEqualTo(url);
    }

    @Test
    public void test_bad_url() {
        String url = "bad_url";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> UrlDocumentLoader.load(url, new TextDocumentParser()))
                .withMessageContaining("no protocol");
    }
}

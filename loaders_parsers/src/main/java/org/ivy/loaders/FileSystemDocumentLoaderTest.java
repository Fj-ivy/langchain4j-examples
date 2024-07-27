package org.ivy.loaders;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class FileSystemDocumentLoaderTest implements WithAssumptions {

    @Test
    void load_bad_file() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loadDocument(Paths.get("bad_file"), new TextDocumentParser()))
                .withMessageContaining("'bad_file' is not a file");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loadDocument(Paths.get("bad_file")))
                .withMessageContaining("'bad_file' is not a file");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loadDocument(Paths.get("/"), new TextDocumentParser()))
                .withMessageContaining("is not a file");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loadDocument(Paths.get("/")))
                .withMessageContaining("is not a file");
    }

    @Test
    void should_load_text_document() {
        Path path = toPath("test-file-utf8.txt");
        Document document = loadDocument(path, new TextDocumentParser());

        assertThat(document.text()).isEqualToIgnoringWhitespace("test content");
        assertThat(document.metadata().getString("file_name")).isEqualTo("test-file-utf8.txt");
        assertThat(Paths.get(document.metadata().getString("absolute_directory_path")).isAbsolute());

        assertThat(loadDocument(path.toString(), new TextDocumentParser())).isEqualTo(document);

        assertThat(loadDocument(path)).isEqualTo(document);
        assertThat(loadDocument(path.toString())).isEqualTo(document);
    }

    private Path toPath(String fileName) {
        try {
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.ivy.easyrag.loaders;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

/**
 * 加载所有类型的文档内容，直接使用
 */
@Service
public class LoaderService {
    /**
     * 加载所有类型的文档内容
     *
     * @param path where to load documents from
     * @return a list of documents
     */
    public List<Document> loadFromFileSystem(String path) {
        return FileSystemDocumentLoader.loadDocuments(path);
    }

    /**
     * 加载所有类型的文档内容，根据过滤器过滤
     *
     * @param path   where to load documents from
     * @param filter the filter to apply to the path
     * @return a list of documents
     */
    public List<Document> loadFromFileSystem(String path, String filter) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(filter);
        return FileSystemDocumentLoader.loadDocuments(path, pathMatcher);
    }

    /**
     * 加载所有类型的文档内容，递归加载
     *
     * @param path where to load documents from
     * @return a list of documents
     */
    public List<Document> loadFromFileSystemRecursive(String path) {
        return FileSystemDocumentLoader.loadDocumentsRecursively(path);
    }

    /**
     * 加载所有类型的文档内容，递归加载，根据过滤器过滤
     *
     * @param path   where to load documents from
     * @param filter the filter to apply to the path
     * @return a list of documents
     */
    public List<Document> loadFromFileSystemRecursive(String path, String filter) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(filter);
        return FileSystemDocumentLoader.loadDocumentsRecursively(path, pathMatcher);
    }
}

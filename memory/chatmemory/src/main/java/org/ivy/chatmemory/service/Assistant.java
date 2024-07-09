package org.ivy.chatmemory.service;

import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {
    String chat(String message);
}

package org.ivy.chatmemory.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}

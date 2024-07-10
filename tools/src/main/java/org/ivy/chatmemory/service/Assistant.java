package org.ivy.chatmemory.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        tools = {"calculator"}
)
public interface Assistant {
    String chat(String userMessage);
}



package org.ivy.tool.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        tools = {"calculator"}
)
public interface Assistant {
    String chat(String userMessage);
}



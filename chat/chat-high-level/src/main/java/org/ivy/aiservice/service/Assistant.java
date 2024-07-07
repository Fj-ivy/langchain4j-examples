package org.ivy.aiservice.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 通过 @AiService 注解声明一个 AI 助手接口，并指定 chatModel 为 openAiChatModel。
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        tools = {"calculator"}
)
public interface Assistant {
    String chat(String userMessage);
}



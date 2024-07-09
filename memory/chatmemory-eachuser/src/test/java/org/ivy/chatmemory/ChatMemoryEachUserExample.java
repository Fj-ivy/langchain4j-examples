package org.ivy.chatmemory;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.ivy.chatmemory.service.Assistant;

public class ChatMemoryEachUserExample {
    public static void main(String[] args) {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(
                        OpenAiChatModel.builder()
                                .baseUrl("xxxxxx")
                                .apiKey("xxxxxx")
                                .build())
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();

        System.out.println(assistant.chat(1, "Hello, my name is Klaus"));
        // Hi Klaus! How can I assist you today?

        System.out.println(assistant.chat(2, "Hello, my name is Francine"));
        // Hello Francine! How can I assist you today?

        System.out.println(assistant.chat(1, "What is my name?"));
        // Your name is Klaus.

        System.out.println(assistant.chat(2, "What is my name?"));
    }
}

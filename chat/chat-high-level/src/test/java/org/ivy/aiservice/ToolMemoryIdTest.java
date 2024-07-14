package org.ivy.aiservice;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import org.junit.jupiter.api.Test;

public class ToolMemoryIdTest {

    interface Assistant {
        String chat(@MemoryId int memoryId, @UserMessage String userMessage);
    }

    /**
     * {@link ToolMemoryId}, 目前看没有什么作用，但是在定义是需要 和 {@link MemoryId}一样的类型
     */
    static class Tools {
        @Tool("Calculates the sum of two numbers")
        int add(@ToolMemoryId int memoryId, int a, int b) {
            System.out.println("Called add with a=" + a + ", b=" + b);
            return a + b;
        }
    }

    @Test
    public void testToolMemoryId() {
        OpenAiChatModel openAiChatModel = OpenAiChatModel.builder()
                .apiKey("xxx")
                .baseUrl("xxx")
                .build();
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .tools(new Tools())
                .build();

        String chat = assistant.chat(1, "add 2 3");
        System.out.println(chat);
    }
}

package org.ivy.aiservice;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.ivy.aiservice.func.Calculator;
import org.ivy.aiservice.service.Assistant;

public class ServiceWithToolExample {
    // Example usage of the Assistant class with a Calculator tool， Java Example
    public static void main(String[] args) {
        Assistant assistant = AiServices.builder(Assistant.class)
                // WARNING! "demo" key does not support tools
                .chatLanguageModel(OpenAiChatModel.builder()
                        .baseUrl("xxx")
                        .apiKey("xxxx")
                        .build()
                )
                .tools(new Calculator())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        String question = "What is the square root of the sum of the numbers of letters in the words \"hello\" and \"world\"?";

        String answer = assistant.chat(question);

        System.out.println(answer);
        // The square root of the sum of the number of letters in the words "hello" and "world" is approximately 3.162.
    }
}

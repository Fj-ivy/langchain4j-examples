package org.ivy.codeexecuteengine.judge0;

import dev.langchain4j.code.judge0.Judge0JavaScriptExecutionTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.ivy.codeexecuteengine.Assistant;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Judge0ToolService {
    private final OpenAiChatModel model;
    private final Judge0JavaScriptExecutionTool judge0;

    public String execute(String message) {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(judge0)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return assistant.chat(message);
    }
}

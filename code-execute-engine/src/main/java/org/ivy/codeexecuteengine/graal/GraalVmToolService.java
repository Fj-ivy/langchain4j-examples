package org.ivy.codeexecuteengine.graal;

import dev.langchain4j.agent.tool.graalvm.GraalVmJavaScriptExecutionTool;
import dev.langchain4j.agent.tool.graalvm.GraalVmPythonExecutionTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.ivy.codeexecuteengine.Assistant;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GraalVmToolService {
    private final OpenAiChatModel model;
    private final GraalVmJavaScriptExecutionTool graalVmJavaScriptExecutionTool;
    private final GraalVmPythonExecutionTool graalVmPythonExecutionTool;

    public String execute(String text) {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(graalVmJavaScriptExecutionTool)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return assistant.chat(text);
    }

    public String executePython(String text) {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(graalVmPythonExecutionTool)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return assistant.chat(text);
    }

}

package org.ivy.lowlevel;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ll/")
@RestController
public class LowLevelChatController {
    private final OpenAiChatModel openAiChatModel;
    private final OllamaChatModel ollamaChatModel;

    public LowLevelChatController(OpenAiChatModel openAiChatModel,
                                  OllamaChatModel ollamaChatModel) {
        this.openAiChatModel = openAiChatModel;
        this.ollamaChatModel = ollamaChatModel;
    }

    @GetMapping("ollama-chat")
    public String ollamaChat(String prompt) {
        return ollamaChatModel.generate(prompt);
    }

    @GetMapping("open-ai-chat")
    public String openAiChat(String prompt) {
        return openAiChatModel.generate(prompt);
    }
}

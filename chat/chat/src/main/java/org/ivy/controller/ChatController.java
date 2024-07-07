package org.ivy.controller;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ll/")
@RestController
public class ChatController {

    private final OllamaChatModel ollamaChatModel;
    private final OpenAiChatModel openAiChatModel;

    public ChatController(OllamaChatModel ollamaChatModel, OpenAiChatModel openAiChatModel) {
        this.ollamaChatModel = ollamaChatModel;
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping("chat")
    public String chat(String prompt) {
        return ollamaChatModel.generate(prompt);
    }

    @GetMapping("openai/chat")
    public String openAiChat(String prompt) {
        return openAiChatModel.generate(prompt);
    }
}

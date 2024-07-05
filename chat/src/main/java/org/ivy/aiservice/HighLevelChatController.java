package org.ivy.aiservice;

import org.ivy.aiservice.service.Assistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hl")
@RestController
public class HighLevelChatController {
    private final Assistant assistant;

    public HighLevelChatController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/chat")
    public String chat(
            @RequestParam(value = "prompt",
                    defaultValue = "What is the square root of the sum of the numbers of letters in the words \"hello\" and \"world\"?")
            String prompt) {
        return assistant.chat(prompt);
    }
}

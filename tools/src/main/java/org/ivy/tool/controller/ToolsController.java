package org.ivy.tool.controller;

import org.ivy.tool.service.Assistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolsController {
    private final Assistant assistant;

    public ToolsController(Assistant assistant) {
        this.assistant = assistant;
    }
    @GetMapping("/cal")
    public String calculate(String prompt) {
        return assistant.chat(prompt);
    }
}

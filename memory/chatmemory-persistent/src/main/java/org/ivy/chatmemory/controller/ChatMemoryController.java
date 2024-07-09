package org.ivy.chatmemory.controller;

import org.ivy.chatmemory.service.Assistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/memory")
@RestController
public class ChatMemoryController {
    private final Assistant assistant;

    public ChatMemoryController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/chat/{memoryId}")
    public String chatEachUser(@PathVariable int memoryId, String prompt) {
        return assistant.chat(memoryId, prompt);
    }
}

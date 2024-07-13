package org.ivy.chatmemory.controller;

import org.ivy.chatmemory.service.Translator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslatorController {
    private final Translator translator;

    public TranslatorController(Translator translator) {
        this.translator = translator;
    }

    @GetMapping("/translate")
    public String translate(@RequestParam("text") String text, @RequestParam("language") String language) {
        return translator.translate(text, language);
    }
}

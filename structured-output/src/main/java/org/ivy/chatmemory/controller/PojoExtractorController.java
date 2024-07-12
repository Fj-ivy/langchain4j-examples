package org.ivy.chatmemory.controller;

import org.ivy.chatmemory.service.PojoDescription;
import org.ivy.chatmemory.service.PojoExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class PojoExtractorController {
    private final PojoExtractor pojoExtractor;
    private final PojoDescription pojoDescription;

    public PojoExtractorController(PojoExtractor pojoExtractor,
                                   PojoDescription pojoDescription) {
        this.pojoExtractor = pojoExtractor;
        this.pojoDescription = pojoDescription;
    }

    @GetMapping("/pojo")
    public PojoExtractor.Person extractPerson(String prompt) {
        return pojoExtractor.extractPerson(prompt);
    }

    @GetMapping("/recipe")
    public PojoDescription.Recipe createRecipe(String[] prompt) {
        return pojoDescription.createRecipe(prompt);
    }

    @GetMapping("/recipe2")
    public PojoDescription.Recipe createRecipe2(String[] prompt) {
        PojoDescription.CreateRecipePrompt createRecipePrompt = new PojoDescription.CreateRecipePrompt(
                "salad", Arrays.asList(prompt)
        );
        return pojoDescription.createRecipe(createRecipePrompt);
    }
}

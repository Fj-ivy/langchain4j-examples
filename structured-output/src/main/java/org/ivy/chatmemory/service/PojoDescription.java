package org.ivy.chatmemory.service;

import dev.langchain4j.model.input.structured.StructuredPrompt;
import dev.langchain4j.model.output.structured.Description;
import dev.langchain4j.service.spring.AiService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AiService
public interface PojoDescription {

    // ======================================给出原材料创建菜肴的步骤和时间 ==============================
    /**
     * 给出一组原料，做出菜肴
     *
     * @param ingredients：菜肴的原料
     * @return Recipe
     */
    Recipe createRecipe(String... ingredients);

    Recipe createRecipe(CreateRecipePrompt prompt);

    /**
     * 烹饪步骤、需要时间等
     */
    @Getter
    @Setter
    @ToString
    class Recipe {
        // 字段添加描述信息
        @Description("short title, 3 words maximum")
        private String title;
        @Description("short description, 2 sentences maximum")
        private String description;
        @Description("each step should be described in 4 words, steps should be rhyme")
        private List<String> steps;
        private Integer preparationTimeMinutes;
    }

    @Getter
    @AllArgsConstructor
    @StructuredPrompt("Create a recipe of a {{dish}} that can be prepared using only {{ingredients}}")
    class CreateRecipePrompt {
        private String dish;
        private List<String> ingredients;
    }
}

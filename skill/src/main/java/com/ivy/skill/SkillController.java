package com.ivy.skill;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.skills.FileSystemSkill;
import dev.langchain4j.skills.FileSystemSkillLoader;
import dev.langchain4j.skills.Skills;
import dev.langchain4j.skills.shell.RunShellCommandToolConfig;
import dev.langchain4j.skills.shell.ShellSkills;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author fangjie33
 * @date 2026/3/12 17:52
 * @description skill 调用执行示例
 */
@RequestMapping("/skill")
@RestController
public class SkillController {

    @Resource
    private ChatModel chatModel;

    @GetMapping("/chat")
    public String model(@RequestParam(value = "message", defaultValue = "hello") String message) {

        List<FileSystemSkill> skill = FileSystemSkillLoader.loadSkills(toPath("skills"));

        Skills skills = Skills.from(skill);

        ShellSkills shellSkill = ShellSkills.builder()
                .skills(skill)
                .runShellCommandToolConfig(RunShellCommandToolConfig.builder().build())
                .build();
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .systemMessage("""
                        You have access to the following skills:
                        %s
                        When the user's request relates to one of these skills, read its SKILL.md before proceeding.
                        """.formatted(shellSkill.formatAvailableSkills()))
                .toolProviders(shellSkill.toolProvider(), skills.toolProvider())
                .build();

        return assistant.chat(message);
    }


    interface Assistant {
        String chat(String userMessage);
    }


    private Path toPath(String fileName) {
        try {
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

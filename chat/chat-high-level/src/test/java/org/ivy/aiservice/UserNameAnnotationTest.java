package org.ivy.aiservice;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.UserName;
import org.junit.jupiter.api.Test;

public class UserNameAnnotationTest {

    interface ChatAssistant {
        String chat(@UserName String name, @UserMessage String message);
    }

    @Test
    public void testUsernameAnnotation() {
        OpenAiChatModel openAiChatModel = OpenAiChatModel.builder()
                .apiKey("xxx")
                .baseUrl("xxx")
                .build();
        ChatAssistant chatAssistant = AiServices.create(ChatAssistant.class, openAiChatModel);

        String answer = chatAssistant.chat("fangjie", "Hi, tell me my name if you see it.");
        System.out.println(answer); // Hello! Your name is Klaus. How can I assist you today?
    }

    // test with two usernames
    interface ChatAssistantTwoUserName {
        // 不论参数有几个@UserName注解，只会取第一个匹配到的name，其它将会忽略
        // 这个@UserName指定了提供的终端用户，并不是所有的大模型都支持这个UserName
        String chat(@UserName String name1, @UserName String name2, @UserMessage String message);
    }

    @Test
    public void testUsernameAnnotation2() {
        OpenAiChatModel openAiChatModel = OpenAiChatModel.builder()
                .apiKey("xxxx")
                .baseUrl("xxxx")
                .build();
        ChatAssistantTwoUserName chatAssistant = AiServices.create(ChatAssistantTwoUserName.class, openAiChatModel);

        String answer = chatAssistant.chat("fangjie","zhoujie", "Hi, tell me my name if you see it.");
        System.out.println(answer); // Hello! Your name is Klaus. How can I assist you today?
    }

}

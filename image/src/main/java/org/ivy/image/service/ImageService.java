package org.ivy.image.service;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.output.Response;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel;
    private final OpenAiChatModel openAiChatModel;

    public ImageService(OpenAiImageModel openAiImageModel, OpenAiChatModel openAiChatModel) {
        this.openAiImageModel = openAiImageModel;
        this.openAiChatModel = openAiChatModel;
    }

    public String generateImage(String prompt) {
        Response<Image> generate = openAiImageModel.generate(prompt);
        String url = generate.content().url().toString();
        return String.format("<img src='%s' alt='%s'>", url, prompt);
    }

    public String see(String prompt) {
        UserMessage userMessage = UserMessage.from(
                TextContent.from(prompt),
                ImageContent.from("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png")
        );
        Response<AiMessage> generate = openAiChatModel.generate(userMessage);
        return generate.content().text();
    }
}

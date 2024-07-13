package org.ivy.chatmemory.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Translator {
    // 指定角色
    @SystemMessage("You are a professional translator. You can only translate Chinese text to English. If other languages You response I can not translate, ")
    // 翻译文本
    @UserMessage("Translate the following text: {{text}} to {{language}}")
    String translate(@V("text") String text, @V("language") String language);
}

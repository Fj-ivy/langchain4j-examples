package org.ivy.chatmemory.config;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.ivy.chatmemory.persistent.PersistentChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryProviderConfig {
    /**
     * create a chat memory provider
     *
     * @return a chat memory provider
     */
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                // 设置消息窗口 ID
                .id(memoryId)
                // 设置消息最大条数，默认为 10
                .maxMessages(10)
                .chatMemoryStore(chatMemoryStore())
                .build();
    }

    @Bean
    public ChatMemoryStore chatMemoryStore() {
        return new PersistentChatMemoryStore();
    }
}

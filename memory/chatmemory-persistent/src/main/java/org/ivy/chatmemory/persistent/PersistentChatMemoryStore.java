package org.ivy.chatmemory.persistent;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.List;
import java.util.Map;

import static dev.langchain4j.data.message.ChatMessageDeserializer.messagesFromJson;
import static dev.langchain4j.data.message.ChatMessageSerializer.messagesToJson;
import static org.mapdb.Serializer.INTEGER;
import static org.mapdb.Serializer.STRING;

/**
 * 自定义的持久化聊天存储器
 */
public class PersistentChatMemoryStore implements ChatMemoryStore {
    private final DB db = DBMaker.fileDB("./chat-memory.db").transactionEnable().make();
    private final Map<Integer, String> map = db.hashMap("messages", INTEGER, STRING).createOrOpen();

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String json = map.get((int) memoryId);
        return messagesFromJson(json);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        String json = messagesToJson(messages); // 序列化消息
        map.put((int) memoryId, json);
        db.commit(); // 提交事务
    }

    @Override
    public void deleteMessages(Object memoryId) {
        map.remove((int) memoryId);
        db.commit();
    }
}

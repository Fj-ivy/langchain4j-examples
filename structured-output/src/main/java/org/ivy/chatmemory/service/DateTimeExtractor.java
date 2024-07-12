package org.ivy.chatmemory.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AiService
public interface DateTimeExtractor {
    @UserMessage("Extract date from {{it}}")
    LocalDate extractDate(String text);

    @UserMessage("Extract time from {{it}}")
    LocalTime extractTime(String text);

    @UserMessage("Extract date and time from {{it}}")
    LocalDateTime extractDateTime(String text);
}

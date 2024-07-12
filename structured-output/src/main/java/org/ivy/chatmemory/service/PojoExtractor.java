package org.ivy.chatmemory.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AiService
public interface PojoExtractor {

    @UserMessage("Extract information about a person from {{it}}")
    Person extractPerson(String text);


    @Getter
    @Setter
    @ToString
    class Person {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
    }
}

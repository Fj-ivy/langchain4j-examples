package org.ivy.chatmemory.tool;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Tool("Calculates the sum of two numbers")
    public int add(int a, int b) {
        System.out.println("Called add with a=" + a + ", b=" + b);
        return a + b;
    }
}

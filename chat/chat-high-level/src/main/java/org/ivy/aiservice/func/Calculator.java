package org.ivy.aiservice.func;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Tool("Calculates the length of a string")
    int stringLength(String s) {
        System.out.println("Called stringLength with s='" + s + "'");
        return s.length();
    }

    @Tool("Calculates the sum of two numbers")
    int add(int a, int b) {
        System.out.println("Called add with a=" + a + ", b=" + b);
        return a + b;
    }

    @Tool("Calculates the square root of a number")
    double sqrt(int x) {
        System.out.println("Called sqrt with x=" + x);
        return Math.sqrt(x);
    }
}
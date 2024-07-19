package org.ivy.codeexecuteengine;

import dev.langchain4j.code.CodeExecutionEngine;
import dev.langchain4j.code.graalvm.GraalVmJavaScriptExecutionEngine;
import dev.langchain4j.code.graalvm.GraalVmPythonExecutionEngine;

public class GraalVmExecutionEngineTest {

    public static void main(String[] args) {
        String javaScript = javaScript();
        System.out.println("javaScript: " + javaScript);

        String python = python();
        System.out.println("python: " + python);
    }

    public static String javaScript() {
        String code = """
                function fibonacci(n) {
                                         if (n <= 1) return n;
                                         return fibonacci(n - 1) + fibonacci(n - 2);
                                     }
                
                                     fibonacci(10)
                """;
        CodeExecutionEngine engine = new GraalVmJavaScriptExecutionEngine();
        return engine.execute(code);
    }


    public static String python() {
        String code = """
                def fibonacci(n):
                    if n <= 1:
                        return n
                    return fibonacci(n - 1) + fibonacci(n - 2)
                
                fibonacci(10)
                """;
        CodeExecutionEngine engine = new GraalVmPythonExecutionEngine();
        return engine.execute(code);
    }
}

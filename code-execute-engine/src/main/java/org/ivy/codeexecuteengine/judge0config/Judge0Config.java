package org.ivy.codeexecuteengine.judge0config;

import dev.langchain4j.code.judge0.Judge0JavaScriptExecutionTool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Judge0Config {
    @Bean
    public Judge0JavaScriptExecutionTool judge0JavaScriptExecutionTool() {
        return new Judge0JavaScriptExecutionTool(
                "d71e45f899mshfc8bffd2eeaf2f1p1f7adajsnee2401c1b95a"
        );
    }
}

package org.ivy.codeexecuteengine.toolconfig;

import dev.langchain4j.agent.tool.graalvm.GraalVmJavaScriptExecutionTool;
import dev.langchain4j.agent.tool.graalvm.GraalVmPythonExecutionTool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraalVmConfig {
    @Bean
    public GraalVmJavaScriptExecutionTool graalVmJavaScriptExecutionTool() {
        return new GraalVmJavaScriptExecutionTool();
    }

    @Bean
    public GraalVmPythonExecutionTool graalVmPythonExecutionTool() {
        return new GraalVmPythonExecutionTool();
    }
}

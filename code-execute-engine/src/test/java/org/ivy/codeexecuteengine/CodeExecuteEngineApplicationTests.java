package org.ivy.codeexecuteengine;

import jakarta.annotation.Resource;
import org.ivy.codeexecuteengine.graal.GraalVmToolService;
import org.ivy.codeexecuteengine.judge0.Judge0ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CodeExecuteEngineApplicationTests {

    @Resource
    private GraalVmToolService graalVmToolService;

    @Resource
    private Judge0ToolService judge0ToolService;

//    @Test
    void contextLoads() {
        String answer = graalVmToolService.execute(
                "What is the square root of 485906798473894056 in scientific notation?"
        );
        System.out.println(answer);
        assertThat(answer).contains("6.97");
    }

//    @Test
    void pythonCodeExecution() {
        String answer = graalVmToolService.executePython(
                "What is the square root of 485906798473894056 in scientific notation?"
        );
        System.out.println(answer);
        assertThat(answer).contains("6.97");
    }

//    @Test
    void judge0CodeExecution() {
        String answer = judge0ToolService.execute(
                "What is the square root of 485906798473894056 in scientific notation?"
        );
        System.out.println(answer);
        assertThat(answer).contains("6.97");
    }
}

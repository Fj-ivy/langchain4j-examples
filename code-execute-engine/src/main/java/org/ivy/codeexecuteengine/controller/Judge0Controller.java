package org.ivy.codeexecuteengine.controller;

import lombok.RequiredArgsConstructor;
import org.ivy.codeexecuteengine.judge0.Judge0ToolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Judge0Controller {
    private final Judge0ToolService judge0ToolService;

    @GetMapping("/judge0/js")
    public String tool(@RequestParam(value = "message",
            defaultValue = "What is the square root of 485906798473894056 in scientific notation?") String message) {
        return judge0ToolService.execute(message);
    }
}


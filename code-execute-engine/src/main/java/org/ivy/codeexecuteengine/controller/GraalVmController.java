package org.ivy.codeexecuteengine.controller;

import jakarta.annotation.Resource;
import org.ivy.codeexecuteengine.graal.GraalVmToolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graalvm")
public class GraalVmController {
    @Resource
    private GraalVmToolService graalVmToolService;

    @GetMapping("/js")
    public String tool(@RequestParam(value = "message",
            defaultValue = "What is the square root of 485906798473894056 in scientific notation?") String message) {
        return graalVmToolService.execute(message);
    }


    @GetMapping("/python")
    public String pythonTool(@RequestParam(value = "message",
            defaultValue = "What is the square root of 485906798473894056 in scientific notation?") String message) {
        return graalVmToolService.executePython(message);
    }
}

package org.ivy.image.controller;

import org.ivy.image.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    private final ImageService imageservice;

    public ImageController(ImageService imageservice) {
        this.imageservice = imageservice;
    }

    @GetMapping("/image")
    public String generateImage(@RequestParam(
            value = "prompt",
            defaultValue = "Donald Duck in New York, cartoon style")
                                String prompt) {
        return imageservice.generateImage(prompt);
    }

    @GetMapping("/see")
    public String see(@RequestParam(required = false,defaultValue = "What do you see?") String prompt) {
        return imageservice.see(prompt);
    }
}

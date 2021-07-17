package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StaticNameController {
    private String name = "abcdefg";

    @GetMapping("/name")
    public String getStaticName() {
        return String.format("The name is  %s", name);
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/hello")

    public String sayHello() {
        return "Hello, World!";
    }

    // return dummy json
    @GetMapping("/dummy-json")
    public String getDummyJson() {
        return "{ \"name\": \"John Doe\", \"email\": \"f5FgM@example.com\" }";
    }
}

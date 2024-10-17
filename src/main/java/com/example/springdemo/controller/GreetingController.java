package com.example.springdemo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.springdemo.vo.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    public Greeting greetingAge(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "age", defaultValue = "30") String age
    ) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), age);
    }

    @GetMapping("/greeting/{name}")
    public Greeting greetingTestPath(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), "39");
    }
}

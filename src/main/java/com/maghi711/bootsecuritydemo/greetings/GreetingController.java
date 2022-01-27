package com.maghi711.bootsecuritydemo.greetings;

import com.maghi711.bootsecuritydemo.greetings.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class GreetingController {

    private GreetingService greetingService;

    @GetMapping("/greeting")
    public Map<String, String> getCurrentTime(String name) {
        return Map.of("message", "Hello, the time now is " + LocalDateTime.now());
    }

    @GetMapping("/check")
    public Map<String, String> check(String name) {
        return greetingService.check(name);
    }
}

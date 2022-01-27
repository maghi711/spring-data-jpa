package com.maghi711.bootsecuritydemo.greetings.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> check(String name) {
        return Map.of("time", LocalDate.now().toString());
    }

}

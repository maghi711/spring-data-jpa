package com.maghi711.bootsecuritydemo.timeofday.repo;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeOfDayRepo {

    public String timeOfDay() {
        return LocalTime.now().toString();
    }
}

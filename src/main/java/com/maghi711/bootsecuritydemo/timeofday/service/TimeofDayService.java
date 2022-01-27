package com.maghi711.bootsecuritydemo.timeofday.service;

import com.maghi711.bootsecuritydemo.timeofday.repo.TimeOfDayRepo;
import org.springframework.stereotype.Service;

@Service
public class TimeofDayService {


    private TimeOfDayRepo timeOfDayRepo;

    public void setTimeOfDayRepo(TimeOfDayRepo timeOfDayRepo) {
        this.timeOfDayRepo = timeOfDayRepo;
    }

    public String timeOfDay() {
        return timeOfDayRepo.timeOfDay();
    }
}

package com.george.apirankguesser.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClipUpdater {
    private final ClipService clipService;

    @Autowired
    public ClipUpdater(ClipService clipService) {
        this.clipService = clipService;
    }

    @PostConstruct
    public void init(){
        clipService.generateDailyClips();
    }

    @Scheduled(cron = "0 0 0 * * *") // every day at midnight
    public void updateDailyClips(){
        clipService.generateDailyClips();
    }
}

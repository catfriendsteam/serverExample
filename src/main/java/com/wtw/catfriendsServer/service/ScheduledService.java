package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduledService {
    private UserRepository userRepository;

    @Scheduled(fixedDelay = 1000)
    public void nodifyUserPerHour() throws InterruptedException{
        System.out.println("scheduleTest!");
    }
}

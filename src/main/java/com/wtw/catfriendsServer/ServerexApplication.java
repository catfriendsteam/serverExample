package com.wtw.catfriendsServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //스케줄러 사용
public class ServerexApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerexApplication.class, args);
    }

}

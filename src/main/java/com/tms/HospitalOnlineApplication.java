package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class HospitalOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalOnlineApplication.class, args);
    }
}

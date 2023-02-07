package com.tms.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Doctor {
    private String name;
    private static final Logger log = LoggerFactory.getLogger(Doctor.class);

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                '}';
    }
}

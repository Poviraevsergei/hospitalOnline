package com.tms.service;

import com.tms.annotations.CheckTimeAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    public void firstMethod() {
        System.out.println("First method!!");
    }

    public void secondMethod() {
        System.out.println("Second method!!");
    }

    @CheckTimeAnnotation
    public String thirdMethod() {
        System.out.println("Third method!!");
        return "RETURNING VALUE!!!";
    }
}
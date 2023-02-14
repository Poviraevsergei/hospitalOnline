package com.tms.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Consultation {
    private int id;
    private Timestamp consultation_time;
    private int doctor_id;
    private int patient_id;
    private String description;
}

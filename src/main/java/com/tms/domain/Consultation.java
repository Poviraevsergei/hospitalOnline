package com.tms.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultation_seq")
    @SequenceGenerator(name = "consultation_seq", sequenceName = "consultation_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "time")
    private Timestamp consultationTime;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "description")
    private String description;
}

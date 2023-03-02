package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = {"userExample"})
@EqualsAndHashCode(exclude = {"userExample"})
@Entity
@Table(name = "telephone_example")
public class TelephoneExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_seq")
    @SequenceGenerator(name = "t_seq", sequenceName = "telephone_example_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "number")
    private String number;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserExample userExample;
}
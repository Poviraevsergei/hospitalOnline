package com.tms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tms.annotations.IsAdult;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private int id;

    @Size(min = 5, max = 8)
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Z]*")
    @Column(name = "last_name")
    private String lastName;

    @Positive
    @IsAdult
    @Column(name = "age")
    private int age;

    @Column(name = "user_login")
    private String login;

    @JsonIgnore
    @Column(name = "user_password")
    private String password;
}
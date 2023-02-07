package com.tms.domain;

import com.tms.annotations.IsAdult;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

    private int id;

    @Size(min = 5, max = 8)
    private String firstName;

    @Pattern(regexp = "[A-Z]*")
    private String lastName;

    @Positive
    @IsAdult
    private int age;
    private String login;
    private String password;
}
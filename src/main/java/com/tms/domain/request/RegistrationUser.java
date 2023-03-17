package com.tms.domain.request;

import lombok.Data;

@Data
public class RegistrationUser {
    private String firstName;
    private String lastName;
    private Integer age;
    private String login;
    private String password;
}

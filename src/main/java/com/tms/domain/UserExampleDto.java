package com.tms.domain;

import lombok.Data;

import java.util.Collection;

@Data
public class UserExampleDto {
    private int id;
    private String username;
    private Collection<TelephoneExample> telephones;
    private CustomerExampleDto customer;
}
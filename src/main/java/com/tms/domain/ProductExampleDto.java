package com.tms.domain;

import lombok.Data;

import java.util.Set;

@Data
public class ProductExampleDto {
    private int id;
    private String productInfo;
    private Set<CustomerExampleDto> customers;
}
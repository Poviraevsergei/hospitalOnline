package com.tms.domain;

import lombok.Data;

import java.util.Set;

@Data
public class CustomerExampleDto {
    private int id;
    private String customerName;
    private UserExampleDto userExample;
    private Set<ProductExampleDto> products;
}
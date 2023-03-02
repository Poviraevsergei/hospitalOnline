package com.tms.controller;

import com.tms.domain.CustomerExample;
import com.tms.domain.CustomerExampleDto;
import com.tms.repository.CustomerExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/customerexample", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerExampleController {

    private final CustomerExampleRepository customerExampleRepository;

    @Autowired
    public CustomerExampleController(CustomerExampleRepository customerExampleRepository) {
        this.customerExampleRepository = customerExampleRepository;
    }

    @GetMapping
    public ResponseEntity<ArrayList<CustomerExampleDto>> getAllCustomersEx() {
        return new ResponseEntity<>(customerExampleRepository.getAllCustomerEx(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerExampleDto> getCustomerById(@PathVariable int id) {
        return new ResponseEntity<>(customerExampleRepository.getCustomerExampleById(id), HttpStatus.OK);
    }
}
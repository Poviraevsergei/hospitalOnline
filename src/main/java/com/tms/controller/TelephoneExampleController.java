package com.tms.controller;

import com.tms.domain.TelephoneExample;
import com.tms.repository.TelephoneExampleRepository;
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
@RequestMapping(value = "/telephoneexample", produces = MediaType.APPLICATION_JSON_VALUE)
public class TelephoneExampleController {

    private final TelephoneExampleRepository telephoneExampleRepository;

    @Autowired
    public TelephoneExampleController(TelephoneExampleRepository telephoneExampleRepository) {
        this.telephoneExampleRepository = telephoneExampleRepository;
    }

    @GetMapping
    public ResponseEntity<ArrayList<TelephoneExample>> getAllTelephonesEx() {
        return new ResponseEntity<>(telephoneExampleRepository.getAllTelephoneEx(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelephoneExample> getTelephoneById(@PathVariable int id) {
        TelephoneExample telephone = telephoneExampleRepository.getTelephoneExampleById(id);
        return new ResponseEntity<>(telephone, HttpStatus.OK);
    }
}
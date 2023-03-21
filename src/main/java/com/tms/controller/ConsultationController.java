package com.tms.controller;

import com.tms.domain.Consultation;
import com.tms.service.ConsultationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/consultation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsultationController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/{id}")
    @Tag(name = "byID")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable int id) {
        Consultation consultation = consultationService.getConsultationById(id);
        return new ResponseEntity<>(consultation, consultation.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Consultation>> getAllConsultations() {
        return new ResponseEntity<>(consultationService.getAllConsultations(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createConsultation(@RequestBody @Valid Consultation consultation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        consultationService.createConsultation(consultation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateComponentById(@RequestBody @Valid Consultation consultation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                log.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        consultationService.updateConsultationById(consultation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody @Valid Consultation consultation) {
        consultationService.deleteConsultation(consultation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
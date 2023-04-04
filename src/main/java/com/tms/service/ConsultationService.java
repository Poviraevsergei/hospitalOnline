package com.tms.service;

import com.tms.domain.Consultation;
import com.tms.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsultationService {

    public ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation getConsultationById(int id) {
        return consultationRepository.findById(id).orElse(new Consultation());
    }

    public ArrayList<Consultation> getAllConsultations() {
        return (ArrayList<Consultation>) consultationRepository.findAll();
    }

    public void createConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public void updateConsultationById(Consultation consultation) {
        consultationRepository.saveAndFlush(consultation);
    }

    public void deleteConsultation(Consultation consultation) {
        consultationRepository.delete(consultation);
    }
}
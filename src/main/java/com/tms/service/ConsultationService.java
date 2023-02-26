package com.tms.service;

import com.tms.domain.Consultation;
import com.tms.domain.User;
import com.tms.mappers.UserMapper;
import com.tms.repository.ConsultationRepository;
import org.aspectj.weaver.ArrayAnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class ConsultationService {

    public ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation getConsultationById(int id) {
        return consultationRepository.getConsultationById(id);
    }

    public ArrayList<Consultation> getAllConsultations() {
        return consultationRepository.getAllConsultations();
    }

    public void createConsultation(Consultation consultation) {
        consultationRepository.createConsultation(consultation);
    }

    public void updateConsultationById(Consultation consultation) {
        consultationRepository.updateConsultation(consultation);
    }

    public void deleteConsultation(Consultation consultation) {
        consultationRepository.deleteConsultation(consultation);
    }
}
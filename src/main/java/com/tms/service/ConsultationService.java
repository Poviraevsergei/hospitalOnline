package com.tms.service;

import com.tms.domain.Consultation;
import com.tms.domain.User;
import com.tms.mappers.UserMapper;
import org.aspectj.weaver.ArrayAnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class ConsultationService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsultationService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Consultation getConsultationById(int id) {
        //TODO:ConsultationService
      return new Consultation();
    }

    public ArrayList<Consultation> getAllConsultations() {
        //TODO:ConsultationService
        return new ArrayList<>();
    }

    public int createConsultation(Consultation consultation) {
        //TODO:ConsultationService
        return 1;
    }

    public int updateConsultationById(Consultation consultation) {
        //TODO:ConsultationService
        return 1;
    }

    public int deleteComponentById(int id) {
        //TODO:ConsultationService
        return 1;
    }
}
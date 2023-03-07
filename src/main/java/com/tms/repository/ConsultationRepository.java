package com.tms.repository;

import com.tms.domain.Consultation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class ConsultationRepository {

    public SessionFactory sessionFactory;

    public ConsultationRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Consultation> getAllConsultations(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Consultation");
        ArrayList<Consultation> list = (ArrayList<Consultation>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Consultation getConsultationById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Consultation consultation = session.get(Consultation.class,id);
        session.getTransaction().commit();
        session.close();
        return consultation;
    }

    public void createConsultation(Consultation consultation){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(consultation);
        session.getTransaction().commit();
        session.close();
    }

    public void updateConsultation(Consultation consultation){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(consultation);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteConsultation(Consultation consultation){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(consultation);
        session.getTransaction().commit();
        session.close();
    }
}

package com.tms.repository;

import com.tms.domain.TelephoneExample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class TelephoneExampleRepository {

    public SessionFactory sessionFactory;

    public TelephoneExampleRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<TelephoneExample> getAllTelephoneEx(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from TelephoneExample ");
        ArrayList<TelephoneExample> list = (ArrayList<TelephoneExample>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public TelephoneExample getTelephoneExampleById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        TelephoneExample ue = session.get(TelephoneExample.class,id);
        session.getTransaction().commit();
        session.close();
        return ue;
    }
}

package com.tms.repository;

import com.tms.domain.Consultation;
import com.tms.domain.UserExample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class UserExampleRepository {

    public SessionFactory sessionFactory;

    public UserExampleRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<UserExample> getAllUserEx(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserExample ");
        ArrayList<UserExample> list = (ArrayList<UserExample>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public UserExample getUserExampleById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserExample ue = session.get(UserExample.class,id);
        session.getTransaction().commit();
        session.close();
        return ue;
    }
}

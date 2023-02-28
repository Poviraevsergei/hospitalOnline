package com.tms.repository;

import com.tms.domain.CustomerExample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class CustomerExampleRepository {

    public SessionFactory sessionFactory;

    public CustomerExampleRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<CustomerExample> getAllCustomerEx(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from CustomerExample ");
        ArrayList<CustomerExample> list = (ArrayList<CustomerExample>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public CustomerExample getCustomerExampleById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CustomerExample ue = session.get(CustomerExample.class,id);
        session.getTransaction().commit();
        session.close();
        return ue;
    }
}

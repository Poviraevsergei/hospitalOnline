package com.tms.repository;

import com.tms.domain.CustomerExample;
import com.tms.domain.CustomerExampleDto;
import com.tms.mappers.HibernateDtoMapper;
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

    public ArrayList<CustomerExampleDto> getAllCustomerEx() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from CustomerExample ");
        ArrayList<CustomerExample> list = (ArrayList<CustomerExample>) query.getResultList();
        ArrayList<CustomerExampleDto> resultList = new ArrayList<>();
        for (CustomerExample ce : list) {
            resultList.add(HibernateDtoMapper.getCustomerExampleDto(ce));
        }
        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    public CustomerExampleDto getCustomerExampleById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CustomerExample ce = session.get(CustomerExample.class, id);
        session.getTransaction().commit();
        session.close();
        return HibernateDtoMapper.getCustomerExampleDto(ce);
    }
}
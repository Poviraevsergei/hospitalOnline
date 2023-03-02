package com.tms.repository;

import com.tms.domain.*;
import com.tms.mappers.HibernateDtoMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class ProductExampleRepository {

    public SessionFactory sessionFactory;

    public ProductExampleRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<ProductExampleDto> getAllProductEx() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ProductExample ");
        ArrayList<ProductExample> list = (ArrayList<ProductExample>) query.getResultList();
        ArrayList<ProductExampleDto> resultList = new ArrayList<>();
        for (ProductExample pe : list) {
            resultList.add(HibernateDtoMapper.getProductExampleDto(pe));
        }
        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    public ProductExampleDto getProductExampleById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProductExample pe = session.get(ProductExample.class, id);
        session.getTransaction().commit();
        session.close();
        return HibernateDtoMapper.getProductExampleDto(pe);
    }
}
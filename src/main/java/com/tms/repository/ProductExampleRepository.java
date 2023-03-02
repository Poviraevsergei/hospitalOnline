package com.tms.repository;

import com.tms.domain.ProductExample;
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

    public ArrayList<ProductExample> getAllProductEx(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ProductExample ");
        ArrayList<ProductExample> list = (ArrayList<ProductExample>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public ProductExample getProductExampleById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProductExample ue = session.get(ProductExample.class,id);
        session.getTransaction().commit();
        session.close();
        return ue;
    }
}
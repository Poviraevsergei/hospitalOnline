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
public class UserExampleRepository {

    public SessionFactory sessionFactory;

    public UserExampleRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<UserExampleDto> getAllUserEx() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserExample ");
        ArrayList<UserExample> list = (ArrayList<UserExample>) query.getResultList();
        ArrayList<UserExampleDto> resultList = new ArrayList<>();
        for (UserExample ue : list) {
            resultList.add(HibernateDtoMapper.getUserExampleDto(ue));
        }
        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    public UserExampleDto getUserExampleById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserExample ue = session.get(UserExample.class, id);
        session.getTransaction().commit();
        session.close();
        return HibernateDtoMapper.getUserExampleDto(ue);
    }
}
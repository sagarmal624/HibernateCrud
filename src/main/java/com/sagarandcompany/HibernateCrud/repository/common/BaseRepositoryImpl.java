package com.sagarandcompany.HibernateCrud.repository.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
public class BaseRepositoryImpl implements BaseRepository {
    @Autowired
    SessionFactory sesssionFactory;
    private Class clazz;


    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object get(Long id) {
        return getSession().get(this.clazz, id);
    }

    @Override

    public Object Load(Long id) {
        return getSession().load(this.clazz, id);
    }

    @Override

    public Object save(Object object) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        Serializable serializable = session.save(object);
        transaction.commit();
        return serializable;
    }

    @Override

    public void delete(Object object) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.delete(object);
        transaction.commit();
    }

    @Override

    public void flush() {
    }

    public Session getSession() {
        return sesssionFactory.getCurrentSession();
    }
}


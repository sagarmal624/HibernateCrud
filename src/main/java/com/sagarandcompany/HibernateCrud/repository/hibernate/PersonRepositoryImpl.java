package com.sagarandcompany.HibernateCrud.repository.hibernate;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.common.BaseRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Repository("personRepositoryImpl")
public class PersonRepositoryImpl extends BaseRepositoryImpl {
    PersonRepositoryImpl() {
        super.setClazz(Person.class);
    }

    public Object save(Person person) {
        return super.save(person);
    }
}

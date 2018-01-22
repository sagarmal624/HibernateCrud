package com.sagarandcompany.HibernateCrud.repository.hibernate;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.common.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;


@Repository("personRepositoryImpl")
public class PersonRepositoryImpl extends BaseRepositoryImpl {
    public PersonRepositoryImpl() {
        super.setClazz(Person.class);
    }

}

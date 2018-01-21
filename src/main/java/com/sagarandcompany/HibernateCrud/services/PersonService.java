package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.hibernate.PersonRepositoryImpl;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepositoryImpl personRepositoryImpl;

    public ResponseDTO save(Person person) {
        Object object = personRepositoryImpl.save(person);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("Person saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }

    public void get() {
    }

    public void delete() {
    }

    public void update() {
    }
}

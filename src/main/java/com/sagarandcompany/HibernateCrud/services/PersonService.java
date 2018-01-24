package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.jpa.PersonRepository;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;

    public ResponseDTO save(Person person) {
        Object object = personRepository.save(person);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("Person saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Long id) {
        personRepository.delete(id);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        responseDTO.setMessage("Person deleted successfuly");
        responseDTO.setStatus(true);
        return responseDTO;
    }


}

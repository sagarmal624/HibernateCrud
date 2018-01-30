package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.jpa.PersonRepository;
import com.sagarandcompany.HibernateCrud.util.PersonDTO;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @PersistenceContext
    EntityManager entityManager;
//    @Autowired
//    PersonRepository personRepository;

    public ResponseDTO save(Person person) {
        Object object = personRepository.save(person);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("Person saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }

    public ResponseDTO get(Long id) {
        Object person = personRepository.getOne(id);
        Object person2 = personRepository.getOne(id);
        Object person3 = personRepository.getOne(id);

        ResponseDTO responseDTO = new ResponseDTO();
        if (person != null) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtils.copyProperties(person, personDTO);

            responseDTO.setStatus(true);
            responseDTO.setData(personDTO);
        }
        Object person4 = personRepository.getOne(id);

        return responseDTO;
    }


    public ResponseDTO delete(Long id) {
        personRepository.delete(id);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(true);
        responseDTO.setMessage("Deleted sucessfully");
        return responseDTO;
    }

    public void update() {
    }
}

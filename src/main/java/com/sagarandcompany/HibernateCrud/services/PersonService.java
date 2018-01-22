package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.hibernate.PersonRepositoryImpl;
import com.sagarandcompany.HibernateCrud.repository.jpa.PersonRepository;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepositoryImpl personRepositoryImpl;


//    @Autowired
//    PersonRepository personRepository;

    public ResponseDTO save(Person person) {
        Object object = personRepositoryImpl.save(person);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("Person saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }

    public ResponseDTO get(Long id) {
        Object person = personRepositoryImpl.get(id);
        ResponseDTO responseDTO = new ResponseDTO();
        if (person != null) {
            responseDTO.setStatus(true);
            responseDTO.setData(person);
        }
        return responseDTO;
    }

    //
//    public ResponseDTO delete(Long id) {
//        personRepository.delete(id);
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setStatus(true);
//        responseDTO.setMessage("Deleted sucessfully");
//        return responseDTO;
//    }

    public void update() {
    }
}

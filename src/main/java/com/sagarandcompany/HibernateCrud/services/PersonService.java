package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.jpa.PersonRepository;
import com.sagarandcompany.HibernateCrud.util.PersonDTO;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager entityManager;
//    @Autowired
//    PersonRepository personRepository;

//    public ResponseDTO save(Person person) {
//        Object object = null;
//        if (person.getId() == null)
//            object = personRepository.save(person);
//        else {
//            Person dbPerson = personRepository.getOne(person.getId());
//            if (person.getName() != null) {
//                dbPerson.setName(person.getName());
//                personRepository.flush();
//                object = dbPerson;
//            }
//        }
//        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
//        if (object != null) {
//            responseDTO.setMessage("Person saved successfuly");
//            responseDTO.setStatus(true);
//        }
//        return responseDTO;
//    }

    @Transactional
    public ResponseDTO save(Person person) {
        Object object = null;
        if (person.getId() == null)
            object = personRepository.save(person);
        else {
            Person dbPerson = entityManager.find(Person.class, person.getId(), LockModeType.PESSIMISTIC_WRITE);

//            entityManager.lock(dbPerson, LockModeType.PESSIMISTIC_WRITE);

            if (person.getName() != null) {
                dbPerson.setName(person.getName());
                object = dbPerson;
            }

        }
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("Person saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }

    public ResponseDTO get(Long id) {
        Object person1 = entityManager.find(Person.class, id);
        entityManager.clear();
        Object person2 = entityManager.find(Person.class, id);
        Object person3 = entityManager.find(Person.class, id);
        ResponseDTO responseDTO = new ResponseDTO();

        if (person1 != null) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtils.copyProperties(person1, personDTO);
            responseDTO.setStatus(true);
            responseDTO.setData(personDTO);
        }
        Object person4 = entityManager.find(Person.class, id);

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

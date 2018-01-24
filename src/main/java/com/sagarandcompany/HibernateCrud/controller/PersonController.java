package com.sagarandcompany.HibernateCrud.controller;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.services.PersonService;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO save(@ModelAttribute("person") Person person) {
        return personService.save(person);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO delete(@PathVariable("id") Long id) {
        return personService.delete(id);
    }

}

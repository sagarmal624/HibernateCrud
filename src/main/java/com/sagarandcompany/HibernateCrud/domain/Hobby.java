package com.sagarandcompany.HibernateCrud.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "hobbies")
    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

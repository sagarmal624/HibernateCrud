package com.sagarandcompany.HibernateCrud.repository.jpa;

import com.sagarandcompany.HibernateCrud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findById(Long id);

    public Person findByEmail(String email);

    public Person findByName(String email);

}

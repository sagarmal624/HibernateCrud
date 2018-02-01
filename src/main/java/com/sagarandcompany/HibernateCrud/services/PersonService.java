package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.Person;
import com.sagarandcompany.HibernateCrud.repository.jpa.PersonRepository;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager entityManager;

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

    public ResponseDTO getAll() {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(groupByClause());
        return responseDTO;
    }

    public List<Person> selectStarFromPerson() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();


        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);


        Root<Person> personRoot = criteriaQuery.from(Person.class);


        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Object aggrigateFunction() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(criteriaBuilder.count(personRoot.get("id")));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    public List<Object[]> groupByClause() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.multiselect(personRoot.get("deptno"), criteriaBuilder.avg(personRoot.get("salary")));
        criteriaQuery.groupBy(personRoot.get("deptno"));
        criteriaQuery.having(criteriaBuilder.gt(personRoot.get("salary"), 4000));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List orderByClause() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);


        criteriaQuery.orderBy(criteriaBuilder.desc(personRoot.get("salary")));


        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List multiSelectClause() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
//        criteriaQuery.select(criteriaBuilder.construct(Person.class, personRoot.get("name")));
        criteriaQuery.multiselect(personRoot.get("id"), personRoot.get("name"), personRoot.get("salary"));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Person> whereClause() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

        Root<Person> personRoot = criteriaQuery.from(Person.class);

        criteriaQuery.where(criteriaBuilder.gt(personRoot.get("salary"), 50000),
                criteriaBuilder.equal(personRoot.get("name"), "Umaguru"));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}

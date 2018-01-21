package com.sagarandcompany.HibernateCrud;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }


}

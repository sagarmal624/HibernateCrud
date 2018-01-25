package com.sagarandcompany.HibernateCrud.repository.jpa;

import com.sagarandcompany.HibernateCrud.domain.TPH.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}

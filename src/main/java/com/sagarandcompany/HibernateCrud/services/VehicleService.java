package com.sagarandcompany.HibernateCrud.services;

import com.sagarandcompany.HibernateCrud.domain.TPH.Vehicle;
import com.sagarandcompany.HibernateCrud.repository.jpa.VehicleRepository;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {


    @Autowired
    VehicleRepository vehicleRepository;

    public ResponseDTO save(Vehicle vehicle) {
        Object object = vehicleRepository.save(vehicle);
        ResponseDTO responseDTO = new ResponseDTO("Something went wrong", false);
        if (object != null) {
            responseDTO.setMessage("vehicle saved successfuly");
            responseDTO.setStatus(true);
        }
        return responseDTO;
    }


}

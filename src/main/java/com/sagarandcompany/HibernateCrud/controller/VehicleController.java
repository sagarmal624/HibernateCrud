package com.sagarandcompany.HibernateCrud.controller;

import com.sagarandcompany.HibernateCrud.domain.TPH.FourWheeler;
import com.sagarandcompany.HibernateCrud.domain.TPH.TwoWheeler;
import com.sagarandcompany.HibernateCrud.services.VehicleService;
import com.sagarandcompany.HibernateCrud.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping(value = "/save/fourWheeler", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO save(@ModelAttribute("fourWheeler") FourWheeler fourWheeler) {
        return vehicleService.save(fourWheeler);
    }

    @PostMapping(value = "/save/twoWheeler", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO save(@ModelAttribute("twoWheeler") TwoWheeler twoWheeler) {
        return vehicleService.save(twoWheeler);
    }
}

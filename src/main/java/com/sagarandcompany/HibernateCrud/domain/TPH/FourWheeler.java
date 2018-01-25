package com.sagarandcompany.HibernateCrud.domain.TPH;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4Wheeler")
public class FourWheeler extends Vehicle {
    private String steeringFourWheeler;

    public String getSteeringFourWheeler() {
        return steeringFourWheeler;
    }

    public void setSteeringFourWheeler(String steeringFourWheeler) {
        this.steeringFourWheeler = steeringFourWheeler;
    }

}

package com.sagarandcompany.HibernateCrud.domain.TPH;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2Wheeler")
public class TwoWheeler extends Vehicle {
    private String steeringTwoWheeler;

    public String getSteeringTwoWheeler() {
        return steeringTwoWheeler;
    }

    public void setSteeringTwoWheeler(String steeringTwoWheeler) {
        this.steeringTwoWheeler = steeringTwoWheeler;
    }
}

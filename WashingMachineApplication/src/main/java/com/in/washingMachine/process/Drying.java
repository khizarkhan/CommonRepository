package com.in.washingMachine.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by khizar khan 
 */
@Entity
@DiscriminatorValue("drying")
public class Drying extends Process {
    public Drying() {
    }

    public Drying(Long duration, Integer temperature, Integer rotationSpeed) {
        super(duration, temperature, rotationSpeed);
    }

    @Override
    public String toString() {
        return "Drying " + super.toString();
    }
}

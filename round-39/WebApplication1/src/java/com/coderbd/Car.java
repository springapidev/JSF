package com.coderbd;

import java.util.Objects;

public class Car {

    private String carName;
    private String carDetails;

    public Car() {
    }

    public Car(String carName, String carDetails) {
        this.carName = carName;
        this.carDetails = carDetails;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarDetails() {
        return carDetails;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.carName, other.carName)) {
            return false;
        }
        if (!Objects.equals(this.carDetails, other.carDetails)) {
            return false;
        }
        return true;
    }
    

}

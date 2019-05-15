package com.coderbd;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CarController {

    private List<Car> cars;

    public List<Car> getCars() {
        cars = new ArrayList<>();
        cars.add(new Car("Bd Nano", "Bangladesh will start producing BD anano soon"));
        cars.add(new Car("Tata Nano", "Tata Nano project is not success"));
         cars.add(new Car("Paki Nano", "Bangladesh will start producing BD anano soon"));
        cars.add(new Car("China Nano", "Tata Nano project is not success"));
         cars.add(new Car("USA Nano", "Bangladesh will start producing BD anano soon"));
        cars.add(new Car("UK Nano", "Tata Nano project is not success"));
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}

package com.coderbd.controller.ch7;




import com.coderbd.converter.ch7.CarConverter;
import com.coderbd.entity.ch7.Car;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 9/11/12
 */

public class ImageSwitchBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }
}

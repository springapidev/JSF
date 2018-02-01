package com.coderbd.controller.ch7;

import com.coderbd.converter.ch7.CarConverter;
import com.coderbd.entity.ch7.Car;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * User: mertcaliskan
 * Date: 9/11/12
 */
@ManagedBean
@SessionScoped
public class GalleriaBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }
}

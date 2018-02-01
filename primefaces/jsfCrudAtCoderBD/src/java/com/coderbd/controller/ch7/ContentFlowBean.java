package com.coderbd.controller.ch7;

import com.coderbd.converter.ch7.CarConverter;
import com.coderbd.entity.ch7.Car;
import com.coderbd.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by mertcaliskan
 * on 25/01/15.
 */
@ManagedBean
@SessionScoped
public class ContentFlowBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }

    public String showMessage() {
        MessageUtil.addInfoMessage("car.selected");
        return null;
    }
}

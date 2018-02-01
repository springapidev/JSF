package com.coderbd.converter.ch7;

/**
 * User: mertcaliskan
 * Date: 7/9/12
 */

import com.coderbd.entity.ch7.Car;
import org.apache.commons.lang3.StringUtils;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter(value = "com.coderbd.converter.ch7.CarConverter")
public class CarConverter implements Converter {

    public static Map<String, Car> cars = new HashMap<String, Car>();

    static {
        cars.put("CC", new Car("CC", 2008));
        cars.put("Golf", new Car("Golf", 1974));
        cars.put("Jetta", new Car("Jetta", 1979));
        cars.put("Passat", new Car("Passat", 1973));
        cars.put("Polo", new Car("Polo", 1975));
        cars.put("Scirocco", new Car("Scirocco", 1974));
        cars.put("Touareg", new Car("Touareg", 2002));
    }
    
    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        else {
            return cars.get(value);
        }
    }

    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Car) value).getName());
        }
    }
}

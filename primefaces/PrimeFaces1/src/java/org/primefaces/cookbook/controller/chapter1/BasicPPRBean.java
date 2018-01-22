package org.primefaces.cookbook.controller.chapter1;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @Shamim Sarker
 */
@ManagedBean
@SessionScoped
public class BasicPPRBean implements Serializable {

    private String value;
    
    public String updateValue() {
        
        value = String.valueOf(new java.util.Date());
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.cookbook.controller.chapter1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author J2EE-33
 */
@ViewScoped
@ManagedBean
public class Search {
    private String renEmail="false";
    
    public void display(){
    renEmail="true";
    }

    public String getRenEmail() {
        return renEmail;
    }

    public void setRenEmail(String renEmail) {
        this.renEmail = renEmail;
    }
    
    
}

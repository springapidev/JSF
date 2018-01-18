/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author J2EE-33
 */
@SessionScoped
@ManagedBean(name = "flightSearchController")
public class FlightSearchController {
    private FlightSearch flight;

    public FlightSearch getFlight() {
        if(flight == null ){
        flight = new FlightSearch();
        }
        return flight;
    }

    public void setFlight(FlightSearch flight) {
        this.flight = flight;
    }
    
    
}

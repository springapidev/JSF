package com.coderbd.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class RadioView {
     private String gender;
     
    private String console;    
    private String city;
    private String city2;  
    private List<String> cities;  
    private String color;
     
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
    }
 
    public void getGenderValue(){
    
        System.out.println("Gender: "+gender);
    }
    
    
    
    public String getConsole() {
        return console;
    }
 
    public void setConsole(String console) {
        this.console = console;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getCity2() {
        return city2;
    }
 
    public void setCity2(String city2) {
        this.city2 = city2;
    }
 
    public String getColor() {
        return color;
    }
 
    public void setColor(String color) {
        this.color = color;
    }
 
    public List<String> getCities() {
        return cities;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
  
}
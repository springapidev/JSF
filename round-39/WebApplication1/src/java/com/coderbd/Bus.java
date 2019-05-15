package com.coderbd;

public class Bus {

    private String id;
    private String year;
    private String brand;
    private String color;

    public Bus() {
    }

    public Bus(String id, String year, String brand, String color) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

}

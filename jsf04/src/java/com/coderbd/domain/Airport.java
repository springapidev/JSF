package com.coderbd.domain;

public class Airport {
  String code;
  String name;
  public Airport(String code, String name) {
    this.code = code;
    this.name = name;
  }

    public Airport() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
  
  @Override
  public String toString() {
    return code;
  }
}

package com.bnta.chocolate.models;

public class EstateDTO {


    private String name;
    private String country;

    public EstateDTO(String name, String country){
        this.name = name;
        this.country = country;
    }

    public EstateDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

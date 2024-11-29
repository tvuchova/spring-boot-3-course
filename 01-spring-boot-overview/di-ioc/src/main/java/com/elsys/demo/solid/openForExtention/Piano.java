package com.elsys.demo.solid.openForExtention;

public class Piano {
    private String name;
    private String brand;
    private String type;


    public Piano(String name, String brand, String type) {
        this.name = name;
        this.brand = brand;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
}

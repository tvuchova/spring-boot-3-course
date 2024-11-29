package com.elsys.demo.solid.openForExtention;

public class CoolPiano extends Piano {
    private boolean isCool;

    public CoolPiano(String name, String brand, String type, boolean isCool) {
        super(name, brand, type);
        this.isCool = isCool;
    }

    public boolean isCool() {
        return isCool;
    }
}

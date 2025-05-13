package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.GrassType;

public class Stadium {
    private String name;
    private Integer capacity;
    private String address;
    private Double area;
    private GrassType grassType;

    public Stadium(String name, Integer capacity, String address, GrassType grassType, Double area) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.grassType = grassType;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public GrassType getGrassType() {
        return grassType;
    }

    public void setGrassType(GrassType grassType) {
        this.grassType = grassType;
    }
}

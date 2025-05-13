package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;

import java.time.LocalDate;

public class Player extends Person {
    private Integer jerseyNumber;
    private Position position;
    private double shoeSize;
    private double weight;
    private double height;
    private StrongFoot strongFoot;

    public Player(String lastname, String firstname, LocalDate birthday, String gender, Integer salary, Integer jerseyNumber, Position position, double shoeSize, double weight, double height, StrongFoot strongFoot) {
        super(lastname, firstname, birthday, gender, salary);
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.shoeSize = shoeSize;
        this.weight = weight;
        this.height = height;
        this.strongFoot = strongFoot;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    public StrongFoot getStrongFoot() {
        return strongFoot;
    }

    public void setStrongFoot(StrongFoot strongFoot) {
        this.strongFoot = strongFoot;
    }
}

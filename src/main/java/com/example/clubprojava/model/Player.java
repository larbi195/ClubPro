package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.JerseySize;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;
import javafx.beans.property.*;

import java.time.LocalDate;

public class Player extends Person {
    private IntegerProperty jerseyNumber;
    private ObjectProperty<Position> position;
    private DoubleProperty shoeSize;
    private DoubleProperty weight;
    private DoubleProperty height;
    private ObjectProperty<StrongFoot> strongFoot;
    private ObjectProperty<JerseySize> jerseySize;


    public Player(String lastname, String firstname, LocalDate birthday, Gender gender, Integer salary, Integer jerseyNumber, Position position, double shoeSize, double weight, double height, StrongFoot strongFoot, JerseySize jerseySize) {
        super(lastname, firstname, birthday, gender, salary);
        this.jerseyNumber = new SimpleIntegerProperty(jerseyNumber);
        this.position = new SimpleObjectProperty<>(position);
        this.shoeSize = new SimpleDoubleProperty(shoeSize);
        this.weight = new SimpleDoubleProperty(weight);
        this.height = new SimpleDoubleProperty(height);
        this.strongFoot = new SimpleObjectProperty<>(strongFoot);
        this.jerseySize = new SimpleObjectProperty<>(jerseySize);
    }

    public Integer getJerseyNumber() {
        return jerseyNumber.get();
    }

    public IntegerProperty jerseyNumberProperty() { return jerseyNumber; }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber.set(jerseyNumber);
    }

    public Position getPosition() {
        return position.get();
    }

    public ObjectProperty<Position> positionProperty() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }

    public double getWeight() {
        return weight.get();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public double getHeight() {
        return height.get();
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getShoeSize() {
        return shoeSize.get();
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize.set(shoeSize);
    }

    public StrongFoot getStrongFoot() {
        return strongFoot.get();
    }

    public void setStrongFoot(StrongFoot strongFoot) {
        this.strongFoot.set(strongFoot);
    }

    public JerseySize getJerseySize() {
        return jerseySize.get();
    }
    public void setJerseySize(JerseySize jerseySize) {
        this.jerseySize.set(jerseySize);
    }

    public DoubleProperty shoeSizeProperty() {
        return shoeSize;
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public ObjectProperty<StrongFoot> strongFootProperty() {
        return strongFoot;
    }

    public ObjectProperty<JerseySize> jerseySizeProperty() {
        return jerseySize;
    }
}

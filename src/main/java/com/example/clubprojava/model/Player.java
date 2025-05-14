package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.JerseySize;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;

import java.time.LocalDate;

public class Player extends Person implements Affichable {
    private Integer jerseyNumber;
    private Position position;
    private double shoeSize;
    private double weight;
    private double height;
    private StrongFoot strongFoot;
    private JerseySize jerseySize;


    public Player(String lastname, String firstname, LocalDate birthday, Gender gender, Integer salary, Integer jerseyNumber, Position position, double shoeSize, double weight, double height, StrongFoot strongFoot, JerseySize jerseySize) {
        super(lastname, firstname, birthday, gender, salary);
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.shoeSize = shoeSize;
        this.weight = weight;
        this.height = height;
        this.strongFoot = strongFoot;
        this.jerseySize = jerseySize;
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

    public JerseySize getJerseySize() {
        return jerseySize;
    }
    public void setJerseySize(JerseySize jerseySize) {
        this.jerseySize = jerseySize;
    }
    @Override
    public String getTexteAffichage() {
        return String.format("Joueur: %s %s | N°%d | Position: %s | Taille: %.1f cm | Poids: %.1f kg | Pointure: %.1f | Pied fort: %s | Taille maillot: %s | Salaire: %d€",
                getFirstname(),
                getLastname(),
                getJerseyNumber(),
                getPosition(),
                getHeight(),
                getWeight(),
                getShoeSize(),
                getStrongFoot(),
                getJerseySize(),
                getSalary()
        );


    }}

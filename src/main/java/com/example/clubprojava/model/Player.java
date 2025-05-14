package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.JerseySize;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.*;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player extends Person implements Affichable {

    @JsonIgnore
    private IntegerProperty jerseyNumber = new SimpleIntegerProperty();
    @JsonIgnore
    private ObjectProperty<Position> position = new SimpleObjectProperty<>();
    @JsonIgnore
    private DoubleProperty shoeSize = new SimpleDoubleProperty();

    @JsonIgnore
    private DoubleProperty weight = new SimpleDoubleProperty();
    @JsonIgnore
    private DoubleProperty height = new SimpleDoubleProperty();
    @JsonIgnore
    private ObjectProperty<StrongFoot> strongFoot = new SimpleObjectProperty<>();
    @JsonIgnore
    private ObjectProperty<JerseySize> jerseySize = new SimpleObjectProperty<>();

    @JsonIgnore
    private String texteAffichage;

    public Player() {
        super();
    }

    @JsonCreator
    public Player(
            @JsonProperty("lastname") String lastname,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("birthday") LocalDate birthday,
            @JsonProperty("gender") Gender gender,
            @JsonProperty("salary") Integer salary,
            @JsonProperty("jerseyNumber") Integer jerseyNumber,
            @JsonProperty("position") Position position,
            @JsonProperty("shoeSize") double shoeSize,
            @JsonProperty("weight") double weight,
            @JsonProperty("height") double height,
            @JsonProperty("strongFoot") StrongFoot strongFoot,
            @JsonProperty("jerseySize") JerseySize jerseySize
    ) {
        super(lastname, firstname, birthday, gender, salary);
        this.jerseyNumber.set(jerseyNumber);
        this.position.set(position);
        this.shoeSize.set(shoeSize);
        this.weight.set(weight);
        this.height.set(height);
        this.strongFoot.set(strongFoot);
        this.jerseySize.set(jerseySize);
    }

    // ⚠️ Champs pour sérialisation/désérialisation Jackson
    @JsonProperty("jerseyNumber")
    public int getJerseyNumber() {
        return jerseyNumber.get();
    }

    @JsonProperty("jerseyNumber")
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber.set(jerseyNumber);
    }

    @JsonProperty("position")
    public Position getPosition() {
        return position.get();
    }

    @JsonProperty("position")
    public void setPosition(Position position) {
        this.position.set(position);
    }

    @JsonProperty("shoeSize")
    public double getShoeSize() {
        return shoeSize.get();
    }

    @JsonProperty("shoeSize")
    public void setShoeSize(double shoeSize) {
        this.shoeSize.set(shoeSize);
    }

    @JsonProperty("weight")
    public double getWeight() {
        return weight.get();
    }

    @JsonProperty("weight")
    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    @JsonProperty("height")
    public double getHeight() {
        return height.get();
    }

    @JsonProperty("height")
    public void setHeight(double height) {
        this.height.set(height);
    }

    @JsonProperty("strongFoot")
    public StrongFoot getStrongFoot() {
        return strongFoot.get();
    }

    @JsonProperty("strongFoot")
    public void setStrongFoot(StrongFoot strongFoot) {
        this.strongFoot.set(strongFoot);
    }

    @JsonProperty("jerseySize")
    public JerseySize getJerseySize() {
        return jerseySize.get();
    }

    @JsonProperty("jerseySize")
    public void setJerseySize(JerseySize jerseySize) {
        this.jerseySize.set(jerseySize);
    }

    // Getters JavaFX
    @JsonIgnore public IntegerProperty jerseyNumberProperty() { return jerseyNumber; }
    @JsonIgnore public ObjectProperty<Position> positionProperty() { return position; }
    @JsonIgnore public DoubleProperty shoeSizeProperty() { return shoeSize; }
    @JsonIgnore public DoubleProperty weightProperty() { return weight; }
    @JsonIgnore public DoubleProperty heightProperty() { return height; }
    @JsonIgnore public ObjectProperty<StrongFoot> strongFootProperty() { return strongFoot; }
    @JsonIgnore public ObjectProperty<JerseySize> jerseySizeProperty() { return jerseySize; }

    // Texte d'affichage non sérialisé
    @JsonIgnore
    public void setTexteAffichage(String texteAffichage) {
        this.texteAffichage = texteAffichage;
    }

    @Override
    @JsonIgnore
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
    }
}

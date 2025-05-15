package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Job;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Staff extends Person implements Affichable {

    @JsonIgnore
    private ObjectProperty<Job> job = new SimpleObjectProperty<>();


    public Staff() {
        super();
    }


    @JsonCreator
    public Staff(
            @JsonProperty("lastname") String lastname,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("birthday") LocalDate birthday,
            @JsonProperty("gender") Gender gender,
            @JsonProperty("salary") Integer salary,
            @JsonProperty("job") Job job
    ) {
        super(lastname, firstname, birthday, gender, salary);
        this.job.set(job);
    }


    @JsonProperty("job")
    public Job getJob() {
        return job.get();
    }

    @JsonProperty("job")
    public void setJob(Job job) {
        this.job.set(job);
    }


    @JsonIgnore
    public ObjectProperty<Job> jobProperty() {
        return job;
    }

    @Override
    @JsonIgnore
    public String getTexteAffichage() {
        return String.format("Staff: %s %s | Poste: %s | Salaire: %d€",
                getFirstname(),
                getLastname(),
                getJob(),
                getSalary()
        );
    }
}

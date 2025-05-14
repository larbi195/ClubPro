package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Job;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Staff extends Person implements Affichable{
    private ObjectProperty<Job> job;


    public Staff(String lastname, String firstname, LocalDate birthday, Gender gender, Integer salary, Job job) {
        super(lastname, firstname, birthday, gender, salary);
        this.job = new SimpleObjectProperty<>(job);
    }

    public Job getJob() {
        return job.get();
    }

    public ObjectProperty<Job> jobProperty() {
        return job;
    }

    public void setJob(Job job) {
        this.job.set(job);
    }

    @Override
    public String getTexteAffichage() {
        return String.format("Staff: %s %s | Poste: %s | Salaire: %d€",
                getFirstname(),
                getLastname(),
                job,
                getSalary()
        );
    }

}
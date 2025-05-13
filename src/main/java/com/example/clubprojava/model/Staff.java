package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Job;

import java.time.LocalDate;

public class Staff extends Person {
    private Job job;


    public Staff(String lastname, String firstname, LocalDate birthday, String gender, Integer salary, Job job) {
        super(lastname, firstname, birthday, gender, salary);
        this.job = job;
    }

    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }

}

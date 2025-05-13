package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private String firstname;
    private String lastname;
    private Integer salary;
    private LocalDate birthday;
    private Gender gender;


    public Person(String lastname, String firstname, LocalDate birthday, Gender gender, Integer salary) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.gender = gender;
        this.salary = salary;
    }


    public LocalDate getBirthday() {
        return birthday;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public Gender getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public int getAge() {
        LocalDate aujourdHui = LocalDate.now();
        return Period.between(this.birthday, aujourdHui).getYears();
    }

}

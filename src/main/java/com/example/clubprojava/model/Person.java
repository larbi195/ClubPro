package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private StringProperty firstname;
    private StringProperty lastname;
    private IntegerProperty salary;
    private ObjectProperty<LocalDate> birthday;
    private ObjectProperty<Gender> gender;

    public Person(String lastname, String firstname, LocalDate birthday, Gender gender, Integer salary) {
        this.lastname = new SimpleStringProperty(lastname);
        this.firstname = new SimpleStringProperty(firstname);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.salary = new SimpleIntegerProperty(salary);
        this.gender = new SimpleObjectProperty<>(gender);

    }

    public Person() {

    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty firstnameProperty() {return firstname;}
    public StringProperty lastnameProperty() {return lastname;}
    public Gender getGender() {
        return gender.get();
    }
    public ObjectProperty<Gender> genderProperty() {
        return gender;
    }

    public Integer getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary.set(salary);
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(this.birthday.get(), today).getYears();
    }

}

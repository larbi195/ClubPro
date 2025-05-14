package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Gender;

import java.time.LocalDate;

public interface Affichable {
    String getFirstname();
    String getLastname();
    Integer getSalary();
    Gender getGender();
    LocalDate getBirthday();
    String getRole(); // Retournera "Player" ou "Staff"
    String getSpecificInfo();

    // Retournera les informations spécifiques selon le type
}

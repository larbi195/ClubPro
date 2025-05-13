package com.example.clubprojava.controller;

import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Player;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class PlayerController {
    @FXML
    private Label welcomeText;
    @FXML
    public void initialize() {
        welcomeText.setText("Page des Joueurs");
    }

}

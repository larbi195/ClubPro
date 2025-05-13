package com.example.clubprojava.controller;

import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Player;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class PlayerController {
    @FXML
    private Label titleText;
    @FXML
    private Label clubName;
    @FXML
    public void initialize() {

        titleText.setText("Page des Joueurs");
        clubName.setText(AppContext.getCurrentClub().getName());
    }

}

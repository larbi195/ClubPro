package com.example.clubprojava.controller;

import com.example.clubprojava.model.*;
import com.example.clubprojava.model.Enum.MatchResult;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MatchController {

    @FXML private TextField opponentField;
    @FXML private DatePicker datePicker;
    @FXML private TextField stadiumField;
    @FXML private TextField capacityField;
    @FXML private ComboBox<MatchResult> resultCombo;
    @FXML private TextField yellowField;
    @FXML private TextField redField;
    @FXML private TextField scoredField;
    @FXML private TextField concededField;

    @FXML
    public void initialize() {
        resultCombo.getItems().setAll(MatchResult.values());
    }

    @FXML
    public void handleSave() {
        try {
            Match match = new Match(datePicker.getValue(),
                    opponentField.getText(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    resultCombo.getValue(),
                    Integer.parseInt(yellowField.getText()),
                    Integer.parseInt(redField.getText()),
                    0, // Goal (non utilisé ?)
                    Integer.parseInt(scoredField.getText()),
                    Integer.parseInt(concededField.getText()));
            match.setOpponent(opponentField.getText());
            match.setDate(datePicker.getValue());

            Stadium stadium = new Stadium();
            stadium.setName(stadiumField.getText());
            stadium.setCapacity(Integer.parseInt(capacityField.getText()));
            match.setStadium(stadium);

            match.setMatchResult(resultCombo.getValue());
            match.setYellowCard(Integer.parseInt(yellowField.getText()));
            match.setRedCard(Integer.parseInt(redField.getText()));
            match.setGoalScored(Integer.parseInt(scoredField.getText()));
            match.setGoalConceded(Integer.parseInt(concededField.getText()));

            Club club = AppContext.getCurrentClub();
            club.getMatches().add(match);  // Ajoute au modèle

            // Fermer la fenêtre
            opponentField.getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie : " + e.getMessage());
        }
    }
}

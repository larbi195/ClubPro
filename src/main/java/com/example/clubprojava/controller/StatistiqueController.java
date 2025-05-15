package com.example.clubprojava.controller;

import com.example.clubprojava.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StatistiqueController {
    @FXML
    public Label clubName;
    @FXML
    public Label outputLabel;
    @FXML
    private Label matchesWonLabel;
    @FXML
    private Label matchesLostLabel;
    @FXML
    private Label matchesPlayedLabel;
    @FXML
    private Label matchesNullLabel;
    @FXML
    private Label yellowCardsLabel;
    @FXML
    private Label redCardsLabel;
    @FXML
    private Label goalsScoredLabel;
    @FXML
    private Label goalsConcededLabel;

    private Statistique statistique;

    @FXML
    public void initialize() {
        Club club = AppContext.getCurrentClub();
        clubName.setText(club.getName());
        statistique = new Statistique(12, 4, 20, 4, 7, 2, 40, 18);
        updateView();
    }

    private void updateView() {
        matchesWonLabel.setText(statistique.getMatchesWon().toString());
        matchesLostLabel.setText(statistique.getMatchesLost().toString());
        matchesPlayedLabel.setText(statistique.getMatchesPlayed().toString());
        matchesNullLabel.setText(statistique.getMatchesNull().toString());
        yellowCardsLabel.setText(statistique.getYellowCards().toString());
        redCardsLabel.setText(statistique.getRedCards().toString());
        goalsScoredLabel.setText(statistique.getGoalsScored().toString());
        goalsConcededLabel.setText(statistique.getGoalsConceded().toString());
    }
}






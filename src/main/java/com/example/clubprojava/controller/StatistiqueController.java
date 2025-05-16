package com.example.clubprojava.controller;

import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Match;
import com.example.clubprojava.model.Statistique;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class StatistiqueController {

    @FXML
    private Label clubName;
    @FXML
    private Label outputLabel;
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

    @FXML
    private Button refreshButton;

    private Club club;
    private Statistique statistique;

    @FXML
    public void initialize() {
        club = AppContext.getCurrentClub();
        clubName.setText(club.getName());
        loadStatistiques();
    }

    @FXML
    private void loadStatistiques() {
        List<Match> matches = club.getMatches();
        statistique = new Statistique(matches);
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

    @FXML
    private void handleRefresh() {
        loadStatistiques();
        outputLabel.setText("Statistiques mises à jour.");
    }
}

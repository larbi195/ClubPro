package com.example.clubprojava.controller;

import com.example.clubprojava.model.*;
import com.example.clubprojava.model.Enum.Championship;
import com.example.clubprojava.model.Enum.MatchResult;
import com.example.clubprojava.model.Enum.TypeJersey;
import com.example.clubprojava.model.Enum.TypeMatch;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MatchController {
    private ObservableList<Match> matchesList;
    @FXML TableView<Match> matchTable;
    @FXML TableColumn<Match,String> dateColum;
    @FXML TableColumn<Match,String> opponentColum;
    @FXML TableColumn<Match, TypeMatch> typeMatchColum;
    @FXML TableColumn<Match, TypeJersey> jerseyColum;
    @FXML TableColumn<Match, Championship> championshipColum;
    @FXML TableColumn<Match,String> stadiumColum;
    @FXML TableColumn<Match,MatchResult> matchResultColum;
    @FXML TableColumn<Match,Integer> yellowCardColum;
    @FXML TableColumn<Match,Integer> redCardColum;
    @FXML TableColumn<Match,Integer> goalScoredColum;
    @FXML TableColumn<Match,Integer> goalConcededColum;


    @FXML Label clubName;
    @FXML private TextField opponentField;
    @FXML private DatePicker datePicker;
    @FXML private TextField stadiumField;
    @FXML private TextField capacityField;
    @FXML private ComboBox<MatchResult> resultCombo;
    @FXML private TextField yellowField;
    @FXML private TextField redField;
    @FXML private TextField scoredField;
    @FXML private TextField concededField;
    private Club club;

    @FXML
    public void initialize() {
        club = AppContext.getCurrentClub();
        clubName.setText(club.getName());
        resultCombo.getItems().setAll(MatchResult.values());

        dateColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        opponentColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpponent()));
        typeMatchColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTypeMatch()));
        jerseyColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getJersey().getTypeJersey()));
        championshipColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getChampionship()));
        stadiumColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStadium().getName()));
        matchResultColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMatchResult()));
        yellowCardColum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYellowCard()).asObject());
        redCardColum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getRedCard()).asObject());
        goalScoredColum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getGoalScored()).asObject());
        goalConcededColum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getGoalConceded()).asObject());



        matchesList = FXCollections.observableArrayList(club.getMatches());
        matchTable.setItems(matchesList);
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
            matchesList.add(match);

        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie : " + e.getMessage());
        }
    }

    @FXML private void handleDelete () {
        Match selectedMatch = matchTable.getSelectionModel().getSelectedItem();
        if (selectedMatch != null) {
            // Supprimer le joueur du club et de la liste observable
            club.getPlayers().remove(selectedMatch);
            matchesList.remove(selectedMatch);

            // Sauvegarde des données
            AppContext.getDataManager().saveData();

        } else {
            System.out.println("Veuillez sélectionner un joueur à supprimer.");
        }
    }
}

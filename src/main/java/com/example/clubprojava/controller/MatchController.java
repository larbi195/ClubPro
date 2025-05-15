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

public class MatchController {

    private ObservableList<Match> matchesList;

    @FXML private TableView<Match> matchTable;
    @FXML private TableColumn<Match, String> dateColum;
    @FXML private TableColumn<Match, String> opponentColum;
    @FXML private TableColumn<Match, TypeMatch> typeMatchColum;
    @FXML private TableColumn<Match, TypeJersey> jerseyColum;
    @FXML private TableColumn<Match, Championship> championshipColum;
    @FXML private TableColumn<Match, String> stadiumColum;
    @FXML private TableColumn<Match, Integer> CapacityColum;
    @FXML private TableColumn<Match, MatchResult> matchResultColum;
    @FXML private TableColumn<Match, Integer> yellowCardColum;
    @FXML private TableColumn<Match, Integer> redCardColum;
    @FXML private TableColumn<Match, Integer> goalScoredColum;
    @FXML private TableColumn<Match, Integer> goalConcededColum;

    @FXML private Label clubName;
    @FXML private TextField opponentField;
    @FXML private ComboBox<TypeMatch> typeDeMatchCombo;
    @FXML private ComboBox<TypeJersey> jerseyCombo;
    @FXML private ComboBox<Championship> championshipCombo;
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
        typeDeMatchCombo.getItems().setAll(TypeMatch.values());
        jerseyCombo.getItems().setAll(TypeJersey.values());
        championshipCombo.getItems().setAll(Championship.values());

        dateColum.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getDate() != null ? cellData.getValue().getDate().toString() : ""));
        opponentColum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpponent()));
        typeMatchColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTypeMatch()));

        jerseyColum.setCellValueFactory(cellData -> {
            Jersey jersey = cellData.getValue().getJersey();
            return new SimpleObjectProperty<>(jersey != null ? jersey.getTypeJersey() : null);
        });

        championshipColum.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getChampionship()));

        stadiumColum.setCellValueFactory(cellData -> {
            Stadium stadium = cellData.getValue().getStadium();
            return new SimpleStringProperty(stadium != null ? stadium.getName() : "");
        });

        CapacityColum.setCellValueFactory(cellData -> {
            Stadium stadium = cellData.getValue().getStadium();
            return new SimpleIntegerProperty(stadium != null ? stadium.getCapacity() : 0).asObject();
        });

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
            Jersey jersey = new Jersey();
            jersey.setTypeJersey(jerseyCombo.getValue());

            Stadium stadium = new Stadium();
            stadium.setName(stadiumField.getText());
            stadium.setCapacity(Integer.parseInt(capacityField.getText()));

            Match match = new Match(
                    datePicker.getValue(),
                    opponentField.getText(),
                    typeDeMatchCombo.getValue(),
                    jersey,
                    championshipCombo.getValue(),
                    null,
                    stadium,
                    resultCombo.getValue(),
                    Integer.parseInt(yellowField.getText()),
                    Integer.parseInt(redField.getText()),
                    0,
                    Integer.parseInt(scoredField.getText()),
                    Integer.parseInt(concededField.getText())
            );

            club.getMatches().add(match);
            matchesList.add(match);
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie : " + e.getMessage());
            e.printStackTrace(); // pour un meilleur débogage
        }
    }

    @FXML
    private void handleDelete() {
        Match selectedMatch = matchTable.getSelectionModel().getSelectedItem();
        if (selectedMatch != null) {
            club.getMatches().remove(selectedMatch);
            matchesList.remove(selectedMatch);
            AppContext.getDataManager().saveData();
        } else {
            System.out.println("Veuillez sélectionner un match à supprimer.");
        }
    }
}

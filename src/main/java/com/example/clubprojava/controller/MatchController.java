package com.example.clubprojava.controller;

import com.example.clubprojava.model.*;
import com.example.clubprojava.model.Enum.*;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MatchController implements Initializable {

    @FXML
    private Label clubNameLabel;

    @FXML
    private TableView<Match> matchTable;

    @FXML
    private TableColumn<Match, String> dateColumn;

    @FXML
    private TableColumn<Match, String> stadiumColumn;

    @FXML
    private TableColumn<Match, Integer> capacityColumn;

    @FXML
    private TableColumn<Match, String> opponentColumn;

    @FXML
    private TableColumn<Match, MatchResult> resultColumn;

    @FXML
    private TableColumn<Match, Integer> goalColumn;

    @FXML
    private TableColumn<Match, Integer> yellowColumn;

    @FXML
    private TableColumn<Match, Integer> redColumn ;

    @FXML
    private TableColumn<Match, Integer> scoredColumn ;

    @FXML
    private TableColumn<Match, Integer> concededColumn ;

    private ObservableList<Match> matchesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Club club = AppContext.getCurrentClub();

        clubNameLabel.setText("Liste des matchs du " + club.getName());

        opponentColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpponent()));

        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));

        stadiumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStadium().getName()));

        capacityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStadium().getCapacity()).asObject());

        matchesList = FXCollections.observableArrayList(club.getMatches());

        resultColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMatchResult()));

        yellowColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYellowCard()).asObject());

        redColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getRedCard()).asObject());

        scoredColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getGoalScored()));

        concededColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getGoalConceded()));

        matchTable.setItems(matchesList);
    }

}

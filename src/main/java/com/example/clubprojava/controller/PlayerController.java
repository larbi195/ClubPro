package com.example.clubprojava.controller;

import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;
import com.example.clubprojava.model.Player;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Club club;
    @FXML
    private Label titleText;
    @FXML
    private Label clubName;
    @FXML
    private ListView playerListView;
    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, String> firstNameColumn;
    @FXML
    private TableColumn<Player, String> lastNameColumn;
    @FXML
    private TableColumn<Player, Position> positionColumn;
    @FXML
    private TableColumn<Player, Integer> ageColumn;

    @FXML
    public void initialize() {
        // Titre de la page
        titleText.setText("Page des Joueurs");

        club = AppContext.getCurrentClub();

        clubName.setText(club.getName());

        // Configure les colonnes (doit correspondre aux noms des getters)
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        ageColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()).asObject());

        // Exemple de données
        ObservableList<Player> players = FXCollections.observableArrayList(club.getPlayers());

        System.out.println(club.getPlayers());

        playerTable.setItems(players);
    }

}

package com.example.clubprojava.controller;

import com.dlsc.formsfx.model.structure.IntegerField;
import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.JerseySize;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Enum.StrongFoot;
import com.example.clubprojava.model.Player;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Club club;
    private ObservableList<Player> playersList;
    @FXML
    private Label clubName;
    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, String> firstNameColumn;
    @FXML
    private TableColumn<Player, String> lastNameColumn;
    @FXML
    private TableColumn<Player, Gender> genderColumn;
    @FXML
    private TableColumn<Player, Integer> ageColumn;
    @FXML
    private TableColumn<Player, Integer> salaryColumn;
    @FXML
    private TableColumn<Player, Position> positionColumn;
    @FXML
    private TableColumn<Player, Integer> jerseyNumberColumn;
    @FXML
    private TableColumn<Player, JerseySize> jerseySizeColumn;
    @FXML
    private TableColumn<Player, Double> shoeSizeColumn;
    @FXML
    private TableColumn<Player, Double> weightColumn;
    @FXML
    private TableColumn<Player, Double> heightColumn;
    @FXML
    private TableColumn<Player, StrongFoot> strongFootColumn;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private RadioButton menRadio;
    @FXML
    private RadioButton womenRadio;
    private ToggleGroup genderGroup;
    @FXML
    private TextField salaryTextField;
    @FXML
    private ComboBox<Position> positionComboBox;

    @FXML
    private Label outputLabel;

    @FXML
    public void initialize() {
        club = AppContext.getCurrentClub();

        clubName.setText(club.getName());

        // Configure les colonnes (doit correspondre aux noms des getters)
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        ageColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()).asObject());
        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        jerseyNumberColumn.setCellValueFactory(cellData -> cellData.getValue().jerseyNumberProperty().asObject());
        jerseySizeColumn.setCellValueFactory(cellData -> cellData.getValue().jerseySizeProperty());
        shoeSizeColumn.setCellValueFactory(cellData -> cellData.getValue().shoeSizeProperty().asObject());
        weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty().asObject());
        heightColumn.setCellValueFactory(cellData -> cellData.getValue().heightProperty().asObject());
        strongFootColumn.setCellValueFactory(cellData -> cellData.getValue().strongFootProperty());

        // Exemple de données
        playersList = FXCollections.observableArrayList(club.getPlayers());

        System.out.println(club.getPlayers());

        playerTable.setItems(playersList);

        positionComboBox.getItems().addAll(Position.values());

        genderGroup = new ToggleGroup();
        menRadio.setToggleGroup(genderGroup);
        womenRadio.setToggleGroup(genderGroup);

        menRadio.setUserData(Gender.MEN);
        womenRadio.setUserData(Gender.WOMAN);
    }

    @FXML
    private void handleSubmit() {
        int salary = 0;
        try {
            salary = Integer.parseInt(salaryTextField.getText());
        } catch (NumberFormatException e) {
            outputLabel.setText("Veuillez entrer un salaire valide.");
            return;
        }
        Player newPlayer = new Player(
            lastNameTextField.getText(),
            firstNameTextField.getText(),
            birthdayDatePicker.getValue(),
            (Gender) genderGroup.getSelectedToggle().getUserData(),
            salary,
            10,
            positionComboBox.getValue(),
            45,
            65,
            1.93,
            StrongFoot.RIGHT,
            JerseySize.L
        );

        club.addPlayer(newPlayer);
        playersList.add(newPlayer);

        // Vider les champs
        firstNameTextField.setText("");
        lastNameTextField.setText("");
    }

}

package com.example.clubprojava.controller;

import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Enum.ColorJersey;
import com.example.clubprojava.model.Enum.JerseySize;
import com.example.clubprojava.model.Enum.StrongFoot;
import com.example.clubprojava.model.Enum.TypeJersey;
import com.example.clubprojava.model.Jersey;
import com.example.clubprojava.model.Player;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class JerseyController {
    @FXML
    private Label clubName;
    @FXML
    private TableView<Jersey> jerseyTable;
    @FXML
    private TableColumn<Jersey, TypeJersey> typeColumn;
    @FXML
    private TableColumn<Jersey, ColorJersey> primaryColorColumn;
    @FXML
    private TableColumn<Jersey, ColorJersey> secondaryColorColumn;
    @FXML
    private RadioButton homeJerseyRadio;
    @FXML
    private RadioButton awayJerseyRadio;
    @FXML
    private RadioButton trainingJerseyRadio;
    @FXML
    private ComboBox<ColorJersey> colorPrimaryComboBox;
    @FXML
    private ComboBox<ColorJersey> colorSecondaryComboBox;
    @FXML
    private Label outputLabel;
    private Club club;
    private ObservableList<Jersey> jerseysList;

    private ToggleGroup jerseyTypeGroup;
    @FXML
    public void initialize() {
        club = AppContext.getCurrentClub();
        clubName.setText(club.getName());

        // Configurer les colonnes du tableau
        typeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTypeJersey()));
        primaryColorColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrimaryColor()));
        secondaryColorColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSecondaryColor()));

        // Récupérer la liste des maillots et la convertir en ObservableArrayList
        jerseysList = FXCollections.observableArrayList(club.getJerseys());

        // Attribuer la listes des maillots dans le tableau
        jerseyTable.setItems(jerseysList);

        // Attribuer les boutons radio pour le type de maillot dans le formulaire
        jerseyTypeGroup = new ToggleGroup();
        homeJerseyRadio.setToggleGroup(jerseyTypeGroup);
        awayJerseyRadio.setToggleGroup(jerseyTypeGroup);
        trainingJerseyRadio.setToggleGroup(jerseyTypeGroup);
        homeJerseyRadio.setUserData(TypeJersey.HOME);
        awayJerseyRadio.setUserData(TypeJersey.HOME);
        trainingJerseyRadio.setUserData(TypeJersey.HOME);

        // Attribuer les choix des couleurs du maillot dans le formulaire
        colorPrimaryComboBox.getItems().addAll(ColorJersey.values());
        colorSecondaryComboBox.getItems().addAll(ColorJersey.values());
    }

    @FXML
    private void handleSubmit() {
        Jersey newJersey = new Jersey(
                (TypeJersey) jerseyTypeGroup.getSelectedToggle().getUserData(),
                colorPrimaryComboBox.getValue(),
                colorSecondaryComboBox.getValue()
        );

        // Ajout dans le club et la table
        club.getJerseys().add(newJersey);
        jerseysList.add(newJersey);  // Met à jour la vue

        // Sauvegarde des données
        AppContext.getDataManager().saveData();
        System.out.println("Joueurs sauvegardés : " + club.getPlayers().size());

        outputLabel.setText("Joueur ajouté avec succès !");
    }
}

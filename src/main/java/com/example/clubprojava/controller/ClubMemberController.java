
package com.example.clubprojava.controller;

import com.example.clubprojava.model.Affichable;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Player;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClubMemberController implements Initializable {


    @FXML
    private Label clubName;

    @FXML
    private TableView<Affichable> membersTableView;

    private Club club;
    private ObservableList<Affichable> membersList;

    public void setClub(Club club) {
        this.club = club;
        // Mettre à jour le nom du club après l'avoir défini
        if (clubName != null) {
            clubName.setText("Club : " + club.getName());
        }

        loadMembers();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        membersList = FXCollections.observableArrayList();

        // Colonnes communes
        TableColumn<Affichable, String> roleColumn = new TableColumn<>("Rôle");
        TableColumn<Affichable, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Affichable, String> prenomColumn = new TableColumn<>("Prénom");
        TableColumn<Affichable, Integer> salaireColumn = new TableColumn<>("Salaire");
        TableColumn<Affichable, String> genreColumn = new TableColumn<>("Genre");
        TableColumn<Affichable, String> naissanceColumn = new TableColumn<>("Date de naissance");

        // Colonnes spécifiques aux joueurs
        TableColumn<Affichable, Integer> numeroColumn = new TableColumn<>("Numéro");
        TableColumn<Affichable, String> positionColumn = new TableColumn<>("Position");
        TableColumn<Affichable, Double> poidsColumn = new TableColumn<>("Poids");
        TableColumn<Affichable, Double> tailleColumn = new TableColumn<>("Taille");
        TableColumn<Affichable, Double> pointureColumn = new TableColumn<>("Pointure");
        TableColumn<Affichable, String> piedFortColumn = new TableColumn<>("Pied fort");
        TableColumn<Affichable, String> tailleMaillotColumn = new TableColumn<>("Taille maillot");

        // Configuration des cellValueFactory pour les colonnes communes
        roleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRole()));
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastname()));
        prenomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstname()));
        salaireColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getSalary()));
        genreColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGender().toString()));
        naissanceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBirthday().toString()));

        // Configuration des cellValueFactory pour les colonnes spécifiques aux joueurs
        numeroColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getJerseyNumber());
            }
            return new SimpleObjectProperty<>(null);
        });

        positionColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getPosition().toString());
            }
            return new SimpleStringProperty("");
        });

        poidsColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getWeight());
            }
            return new SimpleObjectProperty<>(null);
        });

        tailleColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getHeight());
            }
            return new SimpleObjectProperty<>(null);
        });

        pointureColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getShoeSize());
            }
            return new SimpleObjectProperty<>(null);
        });

        piedFortColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getStrongFoot().toString());
            }
            return new SimpleStringProperty("");
        });

        tailleMaillotColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getJerseySize().toString());
            }
            return new SimpleStringProperty("");
        });

        // Ajout des colonnes à la TableView
        membersTableView.getColumns().addAll(
                roleColumn,
                nomColumn,
                prenomColumn,
                salaireColumn,
                genreColumn,
                naissanceColumn,
                numeroColumn,
                positionColumn,
                poidsColumn,
                tailleColumn,
                pointureColumn,
                piedFortColumn,
                tailleMaillotColumn
        );

        membersTableView.setItems(membersList);
    }
    private void loadMembers() {
        if (club != null) {
            membersList.clear();
            membersList.addAll(club.getPlayers());
            membersList.addAll(club.getStaffs());
        }
    }

    @FXML
    private void refreshView() {
        loadMembers();
    }
}
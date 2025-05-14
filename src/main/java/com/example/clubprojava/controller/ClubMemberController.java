
package com.example.clubprojava.controller;

import com.example.clubprojava.model.Affichable;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Player;
import com.example.clubprojava.model.Staff;
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

        // Colonne cachée pour respecter la story
        TableColumn<Affichable, String> texteAffichageColumn = new TableColumn<>("Texte d'affichage");
        texteAffichageColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getTexteAffichage())
        );
        texteAffichageColumn.setVisible(false);

        // Colonnes pour toutes les données
        TableColumn<Affichable, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue() instanceof Player ? "Joueur" : "Staff")
        );

        TableColumn<Affichable, String> prenomColumn = new TableColumn<>("Prénom");
        prenomColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getFirstname());
            } else if (data.getValue() instanceof Staff) {
                return new SimpleStringProperty(((Staff) data.getValue()).getFirstname());
            }
            return new SimpleStringProperty("");
        });

        TableColumn<Affichable, String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getLastname());
            } else if (data.getValue() instanceof Staff) {
                return new SimpleStringProperty(((Staff) data.getValue()).getLastname());
            }
            return new SimpleStringProperty("");
        });

        TableColumn<Affichable, String> posteColumn = new TableColumn<>("Poste/Position");
        posteColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getPosition().toString());
            } else if (data.getValue() instanceof Staff) {
                return new SimpleStringProperty(((Staff) data.getValue()).getJob().toString());
            }
            return new SimpleStringProperty("");
        });

        TableColumn<Affichable, Integer> numeroColumn = new TableColumn<>("Numéro");
        numeroColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getJerseyNumber());
            }
            return new SimpleObjectProperty<>(null);
        });

        TableColumn<Affichable, Double> tailleColumn = new TableColumn<>("Taille (cm)");
        tailleColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getHeight());
            }
            return new SimpleObjectProperty<>(null);
        });

        TableColumn<Affichable, Double> poidsColumn = new TableColumn<>("Poids (kg)");
        poidsColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getWeight());
            }
            return new SimpleObjectProperty<>(null);
        });

        TableColumn<Affichable, Double> pointureColumn = new TableColumn<>("Pointure");
        pointureColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getShoeSize());
            }
            return new SimpleObjectProperty<>(null);
        });

        TableColumn<Affichable, String> piedFortColumn = new TableColumn<>("Pied Fort");
        piedFortColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getStrongFoot().toString());
            }
            return new SimpleStringProperty("");
        });

        TableColumn<Affichable, String> tailleMaillotColumn = new TableColumn<>("Taille Maillot");
        tailleMaillotColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleStringProperty(((Player) data.getValue()).getJerseySize().toString());
            }
            return new SimpleStringProperty("");
        });

        TableColumn<Affichable, Integer> salaireColumn = new TableColumn<>("Salaire (€)");
        salaireColumn.setCellValueFactory(data -> {
            if (data.getValue() instanceof Player) {
                return new SimpleObjectProperty<>(((Player) data.getValue()).getSalary());
            } else if (data.getValue() instanceof Staff) {
                return new SimpleObjectProperty<>(((Staff) data.getValue()).getSalary());
            }
            return new SimpleObjectProperty<>(null);
        });

        // Ajout des colonnes à la TableView
        membersTableView.getColumns().addAll(
                texteAffichageColumn,
                typeColumn,
                prenomColumn,
                nomColumn,
                posteColumn,
                numeroColumn,
                tailleColumn,
                poidsColumn,
                pointureColumn,
                piedFortColumn,
                tailleMaillotColumn,
                salaireColumn
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
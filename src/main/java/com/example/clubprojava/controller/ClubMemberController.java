
package com.example.clubprojava.controller;

import com.example.clubprojava.model.Affichable;
import com.example.clubprojava.model.Club;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClubMemberController implements Initializable {


    @FXML
    private TableView<Affichable> membersTableView;

    private Club club;
    private ObservableList<Affichable> membersList;

    public void setClub(Club club) {
        this.club = club;
        loadMembers();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        membersList = FXCollections.observableArrayList();



        // Configuration de la TableView
        TableColumn<Affichable, String> infoColumn = new TableColumn<>("Information");
        infoColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTexteAffichage())
        );

        membersTableView.getColumns().add(infoColumn);
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
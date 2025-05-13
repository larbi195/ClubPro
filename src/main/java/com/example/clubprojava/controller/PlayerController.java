package com.example.clubprojava.controller;

import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.example.clubprojava.model.Enum.Gender;
import com.example.clubprojava.model.Enum.Position;
import com.example.clubprojava.model.Player;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private List<Player> players = new ArrayList<>();
    @FXML
    private ListView playerListView;

    @FXML
    public void initialize() {

        titleText.setText("Page des Joueurs");

        club = AppContext.getCurrentClub();

        clubName.setText(club.getName());

        List<String> names = club.getPlayers().stream()
                .map(player -> player.getFirstname() + " " + player.getLastname())
                .collect(Collectors.toCollection(ArrayList::new));

        playerListView.getItems().addAll(names);
    }

}

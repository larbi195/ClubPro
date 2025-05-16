package com.example.clubprojava.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class NavController {

    @FXML
    private BorderPane root;

    @FXML
    public void goToPlayer() {
        loadContent("player-view.fxml");
    }

    @FXML
    public void goToClubMembers() {
        loadContent("memberlist.fxml");
    }

    @FXML
    public void goToMatch() {
        loadContent("match-view.fxml");
    }

    @FXML
    public void goToJersey() {loadContent("jersey-view.fxml");}

    @FXML
    public void goToStatistique() {loadContent("statistique-view.fxml");}


    private void loadContent(String fxmlFile) {
        try {
            var resource = getClass().getResource("/com/example/clubprojava/" + fxmlFile);
            Parent view = FXMLLoader.load(resource);
            root.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

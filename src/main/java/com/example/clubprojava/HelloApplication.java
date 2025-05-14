
package com.example.clubprojava;


import com.example.clubprojava.controller.ClubMemberController;

import com.example.clubprojava.model.*;
import com.example.clubprojava.model.Enum.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class HelloApplication extends Application {
    private DataManager dataManager;

    @Override
    public void start(Stage stage) throws IOException {
        List<Player> playersList = new ArrayList<>(Arrays.asList(
                new Player("Bouchouk", "Younès", LocalDate.parse("2002-02-06"), Gender.MEN, 1000, 10, Position.FORWARD, 45, 65, 1.93, StrongFoot.RIGHT, JerseySize.L),
                new Player("Dupont", "Jean", LocalDate.parse("1998-05-12"), Gender.MEN, 800, 8, Position.MIDFIELDER, 42, 70, 1.78, StrongFoot.LEFT, JerseySize.M),
                new Player("Martin", "Claire", LocalDate.parse("2001-07-22"), Gender.WOMAN, 950, 9, Position.DEFENDER, 40, 60, 1.75, StrongFoot.RIGHT, JerseySize.S),
                new Player("Nguyen", "Léo", LocalDate.parse("1999-11-15"), Gender.MEN, 1100, 11, Position.GOALKEEPER, 44, 78, 1.88, StrongFoot.LEFT, JerseySize.L),
                new Player("Moreau", "Sofia", LocalDate.parse("2003-03-30"), Gender.WOMAN, 870, 7, Position.FORWARD, 39, 58, 1.69, StrongFoot.RIGHT, JerseySize.M)
                new Player("Mbappé", "Kylian", LocalDate.of(1998, 12, 20),Gender.MEN, 1000000, 7, Position.FORWARD, 42.5, 73.0, 178.0, StrongFoot.RIGHT, JerseySize.M),
                new Player("Giroud", "Olivier", LocalDate.of(1986, 9, 30), Gender.MEN, 800000, 9, Position.FORWARD, 43.0, 82.0, 193.0, StrongFoot.LEFT, JerseySize.L)
        ));

        List<Staff> staffsList = new ArrayList<>(Arrays.asList(
                new Staff("Hongo", "Roberto", LocalDate.parse("2002-02-06"), Gender.MEN, 1000, Job.COACH),
                new Staff("Macron", "Emmanuel", LocalDate.parse("1998-05-12"), Gender.MEN, 800, Job.PRESIDENT),
                new Staff("Plus", "Dinspi", LocalDate.parse("2001-07-22"), Gender.WOMAN, 950, Job.TEAM_DOCTOR),
                new Staff("Deschamps", "Didier", LocalDate.of(1968, 10, 15),Gender.MEN, 500000, Job.COACH),
                new Staff("Dupont", "Pierre", LocalDate.of(1975, 5, 20), Gender.MEN, 150000, Job.PHYSIOTHERAPIST)
        ));

        Club club = new Club(
                "FC Mahr",
                "Sartrouville",
                1000000,
                "Liga",
                1,
                playersList,
                staffsList,
                new ArrayList<Match>(),
                new ArrayList<Jersey>(),
                new Statistique(0, 0, 0, 0, 0, 0, 0, 0)
        );

        AppContext.setCurrentClub(club);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("player-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("ClubPro");
      
        dataManager = new DataManager(club);

        // Charger la vue (modification de cette partie)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("memberlist.fxml"));

        // Récupérer le contrôleur et initialiser le club
        ClubMemberController controller = fxmlLoader.getController();
        controller.setClub(club);

        stage.setScene(scene);
        stage.show();



    }
    @Override
    public void stop() {
        // Sauvegarde explicite lors de la fermeture de l'application
        if (dataManager != null) {
            dataManager.saveData();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}

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
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Créer des données de test
        List<Player> players = new ArrayList<>();
        players.add(new Player("Mbappé", "Kylian", LocalDate.of(1998, 12, 20),
                Gender.MEN, 1000000, 7, Position.FORWARD, 42.5, 73.0, 178.0,
                StrongFoot.RIGHT, JerseySize.M));
        players.add(new Player("Giroud", "Olivier", LocalDate.of(1986, 9, 30),
                Gender.MEN, 800000, 9, Position.FORWARD, 43.0, 82.0, 193.0,
                StrongFoot.LEFT, JerseySize.L));

        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("Deschamps", "Didier", LocalDate.of(1968, 10, 15),
                Gender.MEN, 500000, Job.COACH));
        staffs.add(new Staff("Dupont", "Pierre", LocalDate.of(1975, 5, 20),
                Gender.MEN, 150000, Job.PHYSIOTHERAPIST));

        // Créer le club
        Club club = new Club("FC Test", "Paris", 100000000.0, "Ligue 1", 1,
                players, staffs, new ArrayList<>(), new ArrayList<>(), new Statistique(0, 0, 0, 0, 0, 0, 0, 0));

        AppContext.setCurrentClub(club);
        // Charger la vue (modification de cette partie)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("memberlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Récupérer le contrôleur et initialiser le club
        ClubMemberController controller = fxmlLoader.getController();
        controller.setClub(club);

        stage.setTitle("Membres du Club");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
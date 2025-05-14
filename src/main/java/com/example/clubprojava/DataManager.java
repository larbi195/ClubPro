package com.example.clubprojava;


import com.example.clubprojava.model.AppContext;
import com.example.clubprojava.model.Club;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class DataManager {
    private static final String DATA_FILE = "club_data.json";
    private static final long SAVE_INTERVAL = 2 * 60 * 1000; // 5 minutes
    private final ObjectMapper objectMapper;
    //private final Club club;
    private final Timer autoSaveTimer;

    public DataManager() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.autoSaveTimer = new Timer(true);

        // Configuration de la sauvegarde automatique
        setupAutoSave();

        // Chargement initial des données
        loadData();

        // Ajout d'un hook pour sauvegarder à la fermeture
        Runtime.getRuntime().addShutdownHook(new Thread(this::saveData));
    }

    private void setupAutoSave() {
        autoSaveTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                saveData();
            }
        }, SAVE_INTERVAL, SAVE_INTERVAL);
    }

    public void saveData() {
        try {
            Club club = AppContext.getCurrentClub();
            if (club != null) {
                objectMapper.writeValue(new File(DATA_FILE), club);
                System.out.println("Données sauvegardées avec succès");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
        }
    }

    public void loadData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try {
                Club savedClub = objectMapper.readValue(file, Club.class);
                AppContext.setCurrentClub(savedClub);
                System.out.println("Données chargées avec succès");
            } catch (IOException e) {
                System.err.println("Erreur lors du chargement: " + e.getMessage());
                // En cas d'erreur, le club sera créé par défaut dans HelloApplication
            }
        } else {
            System.out.println("Fichier de données non trouvé. Un nouveau club sera créé.");
        }
    }


    private void updateClubData(Club savedClub) {
       // club.setName(savedClub.getName());
        //club.setCity(savedClub.getCity());
        //club.setBudget(savedClub.getBudget());
        //club.setLeague(savedClub.getLeague());
        //club.setRanking(savedClub.getRanking());
        //club.setPlayers(savedClub.getPlayers());
        //club.setStaffs(savedClub.getStaffs());
        //club.setMatches(savedClub.getMatches());
        //club.setJerseys(savedClub.getJerseys());
        //club.setStatistique(savedClub.getStatistique());
    }
}


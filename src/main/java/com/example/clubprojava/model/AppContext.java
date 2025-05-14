package com.example.clubprojava.model;

import com.example.clubprojava.DataManager;
import com.example.clubprojava.model.Club;
// AppContext.java
public class AppContext {
    private static Club currentClub;
    private static DataManager dataManager;

    public static Club getCurrentClub() {
        return currentClub;
    }

    public static void setCurrentClub(Club club) {
        currentClub = club;
    }

    public static DataManager getDataManager() {
        return dataManager;
    }

    public static void setDataManager(DataManager manager) {
        dataManager = manager;
    }
}

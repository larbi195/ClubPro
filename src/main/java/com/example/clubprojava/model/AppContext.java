package com.example.clubprojava.model;

import com.example.clubprojava.model.Club;

public class AppContext {
    private static Club currentClub;

    public static Club getCurrentClub() {
        return currentClub;
    }

    public static void setCurrentClub(Club club) {
        currentClub = club;
    }
}
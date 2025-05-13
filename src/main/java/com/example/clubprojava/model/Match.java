package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Championship;
import com.example.clubprojava.model.Enum.TypeMatch;

import java.time.LocalDate;

public class Match {
    private LocalDate date;
    private String opponent;
    private TypeMatch typeMatch;
    private Jersey jersey;
    private Integer score;
    private Championship championship;
    private Team team;

    public Match(LocalDate date, String opponent, TypeMatch typeMatch, Jersey jersey, Integer score, Championship championship) {
        this.date = date;
        this.opponent = opponent;
        this.typeMatch = typeMatch;
        this.jersey = jersey;
        this.score = score;
        this.championship = championship;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public TypeMatch getTypeMatch() {
        return typeMatch;
    }

    public void setTypeMatch(TypeMatch typeMatch) {
        this.typeMatch = typeMatch;
    }

    public Jersey getJersey() {
        return jersey;
    }

    public void setJersey(Jersey jersey) {
        this.jersey = jersey;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

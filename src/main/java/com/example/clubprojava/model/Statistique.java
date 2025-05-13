package com.example.clubprojava.model;

public class Statistique {
    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesPlayed;
    private Integer matchesNull;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalsScored;
    private Integer goalsConceded;

    public Statistique(Integer matchesWon, Integer matchesLost, Integer matchesPlayed, Integer yellowCards, Integer matchesNull, Integer redCards, Integer goalsScored, Integer goalsConceded) {
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesPlayed = matchesPlayed;
        this.yellowCards = yellowCards;
        this.matchesNull = matchesNull;
        this.redCards = redCards;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    public Integer getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(Integer matchesWon) {
        this.matchesWon = matchesWon;
    }

    public Integer getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(Integer matchesLost) {
        this.matchesLost = matchesLost;
    }

    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Integer getMatchesNull() {
        return matchesNull;
    }

    public void setMatchesNull(Integer matchesNull) {
        this.matchesNull = matchesNull;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }
}

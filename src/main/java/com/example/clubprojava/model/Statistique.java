package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.MatchResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Statistique {

    private Integer matchesWon;
    private Integer matchesLost;
    private Integer matchesPlayed;
    private Integer matchesNull;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalsScored;
    private Integer goalsConceded;

    // Constructeur vide
    public Statistique() {}

    // Constructeur principal avec tous les champs
    @JsonCreator
    public Statistique(
            @JsonProperty("matchesWon") Integer matchesWon,
            @JsonProperty("matchesLost") Integer matchesLost,
            @JsonProperty("matchesPlayed") Integer matchesPlayed,
            @JsonProperty("yellowCards") Integer yellowCards,
            @JsonProperty("matchesNull") Integer matchesNull,
            @JsonProperty("redCards") Integer redCards,
            @JsonProperty("goalsScored") Integer goalsScored,
            @JsonProperty("goalsConceded") Integer goalsConceded
    ) {
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesPlayed = matchesPlayed;
        this.matchesNull = matchesNull;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }


    public Statistique(List<Match> matches) {
        this.matchesPlayed = matches.size();
        this.matchesWon = 0;
        this.matchesLost = 0;
        this.matchesNull = 0;
        this.yellowCards = 0;
        this.redCards = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;

        for (Match match : matches) {

            MatchResult matchResult = match.getMatchResult();
            if (matchResult == null ) continue;

            if (matchResult == MatchResult.VICTORY){
                matchesWon++;
            } else if (matchResult == MatchResult.DEFEAT) {
                matchesLost++;
            } else {
                matchesNull++;
            }

            goalsScored += match.getGoalScored();
            goalsConceded += match.getGoalConceded();
            yellowCards += match.getYellowCard() != null ? match.getYellowCard() : 0;
            redCards += match.getRedCard() != null ? match.getRedCard() : 0;
        }
    }

    // Getters & Setters

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

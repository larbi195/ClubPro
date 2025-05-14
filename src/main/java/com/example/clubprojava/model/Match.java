package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Championship;
import com.example.clubprojava.model.Enum.MatchResult;
import com.example.clubprojava.model.Enum.TypeMatch;

import java.time.LocalDate;

public class Match {
    private LocalDate date;
    private String opponent;
    private TypeMatch typeMatch;
    private Jersey jersey;
    private Championship championship;
    private Team team;
    private Stadium stadium;
    private MatchResult matchResult;
    private Integer yellowCard;
    private Integer redCard;
    private Integer goal;
    private Integer goalScored;
    private Integer goalConceded;

    public Match(LocalDate date, String opponent, TypeMatch typeMatch, Jersey jersey, Championship championship, Team team, Stadium stadium, MatchResult matchResult, Integer yellowCard, Integer redCard, Integer goal, Integer goalScored, Integer goalConceded) {
        this.date = date;
        this.opponent = opponent;
        this.typeMatch = typeMatch;
        this.jersey = jersey;
        this.championship = championship;
        this.team = team;
        this.stadium = stadium;
        this.matchResult = matchResult;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
        this.goal = goal;
        this.goalScored = goalScored;
        this.goalConceded = goalConceded;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Integer getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(Integer yellowCard) {
        this.yellowCard = yellowCard;
    }

    public Integer getRedCard() {
        return redCard;
    }

    public void setRedCard(Integer redCard) {
        this.redCard = redCard;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public Integer getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(Integer goalScored) {
        this.goalScored = goalScored;
    }

    public Integer getGoalConceded() {
        return goalConceded;
    }

    public void setGoalConceded(Integer goalConceded) {
        this.goalConceded = goalConceded;
    }
}

package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Job;

public class Club {
    private String name;
    private String city;
    private double budget;
    private String league;
    private Integer ranking;

    public Club(String name, String city, double budget, String league, Integer ranking) {
        this.name = name;
        this.city = city;
        this.budget = budget;
        this.league = league;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}

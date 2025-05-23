package com.example.clubprojava.model;

import com.example.clubprojava.model.Enum.Job;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private String name;
    private String city;
    private double budget;
    private String league;
    private Integer ranking;
    private List<Stadium> stadiums;
    private List<Player> players ;
    private List<Staff> staffs;
    private List<Jersey> jerseys;
    private List<Match> matches;
    private Statistique statistique;



    public Club(String name, String city, double budget, String league, Integer ranking, List<Player> players, List<Staff> staffs, List<Stadium> stadiums, List<Match> matches, List<Jersey> jerseys, Statistique statistique) {
        this.name = name;
        this.city = city;
        this.budget = budget;
        this.league = league;
        this.ranking = ranking;
        this.players = players;
        this.staffs = staffs;
        this.stadiums = stadiums;
        this.matches = matches;
        this.jerseys = jerseys;
        this.statistique = statistique;
    }

    public Club() {
        this.players = new ArrayList<>();
        this.staffs = new ArrayList<>();
        this.stadiums = new ArrayList<>();
        this.jerseys = new ArrayList<>();
        this.matches = new ArrayList<>();
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

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        // Assurez-vous que la liste n'est pas nulle avant d'ajouter
        if (players != null) {
            this.players.add(player);
        } else {
            System.out.println("La liste des joueurs est null");
        }
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Jersey> getJerseys() {
        return jerseys;
    }

    public void setJerseys(List<Jersey> jerseys) {
        this.jerseys = jerseys;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(Match match) {
        if (matches == null) {
            matches = new ArrayList<>();
        }
        this.matches.add(match);
    }


    public Statistique getStatistique() {
        return statistique;
    }

    public void setStatistique(Statistique statistique) {
        this.statistique = statistique;
    }
}

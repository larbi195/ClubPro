package com.example.clubprojava.model;

import java.util.List;

public class Team{
    private List<Player> playerlist ;
    public Team(List<Player> playerlist) {
        this.playerlist = playerlist;
    }

    public Team() {
    }
    public List<Player> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(List<Player> playerlist) {
        this.playerlist = playerlist;
    }
}

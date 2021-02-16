package com.esgi.models;

import java.util.ArrayList;

public class Game {
    private final int difficulty;

    private ArrayList<Island> islands;
    private int season;

    public Game(int difficulty) {
        this.difficulty = difficulty;
        islands = new ArrayList<Island>();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Island getIsland(int i){
        return  islands.get(i);
    }

    public void addIsland(Island island){
        islands.add(island);
    }

    public int addSeason() {
        season+=1;
        if(this.season == 4){
            this.season = 0;
            addScore();
        }
        return season;
    }

    private void addScore(){
        for(Island island: islands){
            island.addScore();
        }
    }
}

package com.esgi.models;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.services.DataService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Game {
    private int season;
    private ArrayList<Island> islands;
    private Calamity calamity;
    private Parameter parameter;

    public Game() {
        super();
        season = 0;
        islands = new ArrayList<Island>();
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter){
        this.parameter = parameter;
    }

    public int getDifficulty() {
        return parameter.getDifficulty();
    }

    public int getSeason() {
        return season;
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public Island getIsland(int i){
        return  islands.get(i);
    }

    public Calamity getCalamity() {
        return calamity;
    }

    public void addIsland(Island island){
        islands.add(island);
    }

    private int addSeason() {
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

    public void setCalamity(){
        int time = addSeason();
        do{
            calamity = DataService.getInstance().getCalamity().isSeason(SeasonType.valueOf(time));
        }while (calamity == null);
    }
}

package com.esgi.models;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.services.DataService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties({"difficulty"})
public class Game {
    private int id;
    private int season;
    private int totalSeason;
    private ArrayList<Island> islands;
    private Calamity calamity;
    private GameType gameType;
    private Parameter parameter;

    public Game() {
        super();
    }

    public Game(GameType gameType) {
        super();
        this.gameType = gameType;
        this.season = -1;
        islands = new ArrayList<Island>();
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDifficulty() {
        return parameter.getDifficulty();
    }

    public int getSeason() {
        return season;
    }

    public int getTotalSeason() {
        return totalSeason;
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public Island getIsland(int i) {
        return islands.get(i);
    }

    public Calamity getCalamity() {
        return calamity;
    }

    public void addIsland(Island island) {
        islands.add(island);
    }

    private int addSeason() {
        season += 1;
        totalSeason += 1;
        if (this.season == 4) {
            this.season = 0;
            endYear();
        }
        return season;
    }

    private void endYear() {
        for (Island island : islands) {
            island.endYear();
        }
    }

    public void setCalamity() {
        int time = addSeason();
        /*do{
            calamity = DataService.getInstance().getCalamity().isSeason(SeasonType.valueOf(time));
        }while (calamity == null);*/
    }

    public void setFaction() {
        for (Island island : islands) {
            for (int i = 0; i < parameter.getMaxsize(); i++) {
                if (parameter.getFactionOn(i)) {
                    Faction faction = new Faction("", 0, i + 3, 10);
                    island.addFaction(faction);
                }
            }
        }
    }

    @Override
    public String toString() {
        return " " + id + " | Name Island: " + islands.get(0).getIslandName() + " | Difficulty: " + parameter.getDifficulty() + " | Total Season: " + totalSeason;
    }
}

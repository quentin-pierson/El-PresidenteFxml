package com.esgi.models;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.services.DataService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Game.class, name = "game"),
        @JsonSubTypes.Type(value = Campaign.class, name = "campaign")
})

@JsonIgnoreProperties({"difficulty", "seasonType"})
public class Game {
    private int id;
    private int season;
    private int totalSeason;
    protected ArrayList<Island> islands;
    protected Calamity calamity;
    private GameType gameType;
    private Parameter parameter;

    public Game() {
        super();
    }

    public Game(int season) {
        super();
        this.season = season;
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

    public void setGameType(GameType gameType){ this.gameType = gameType;}

    public int getDifficulty() {
        return parameter.getDifficulty();
    }

    public int getSeason() {
        return season;
    }

    public SeasonType getSeasonType() {
        return SeasonType.valueOf(season);
    }

    public int getTotalSeason() {
        return totalSeason;
    }

    public GameType getGameType() {
        return gameType;
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

    int addSeason() {
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

    public boolean setCalamity() {
        int time = addSeason();

        for(Island island :islands){
            island.setGlobalSatisfaction();
        }

        do{
            calamity = DataService.getInstance().getCalamity().isSeason(SeasonType.valueOf(time));
        }while (calamity == null);

        return true;
    }

    public void setFaction() {
        for (Island island : islands) {
            for (int i = 0; i < parameter.getMaxsize(); i++) {
                if (parameter.getFactionOn(i)) {
                    Faction faction = new Faction("", 50, i + 3, 15);
                    island.addFaction(faction);
                }
            }
            int food = island.getCitizen()*6;
            island.addStockFood(food);
        }
    }

    @Override
    public String toString() {
        return " " + id + " | Name Island: " + islands.get(0).getIslandName() + " | Difficulty: " + parameter.getDifficulty() + " | Total Season: " + totalSeason;
    }
}

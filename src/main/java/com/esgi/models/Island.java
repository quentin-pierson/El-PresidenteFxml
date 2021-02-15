package com.esgi.models;

import java.util.ArrayList;

public class Island {

    private final String islandName;
    private final String dictatorName;
    private final String citizensName;
    private int season;
    private final int difficulty;
    private int agriculture;
    private int stockFood;
    private int industry;
    private int treasury;
    private int score;
    private float globalSatisfaction;
    private ArrayList<Faction> factions;

    public Island(String islandName, String dictatorName, String citizensName, int season, int difficulty, int agriculture, int stockFood, int industry, int treasury, float globalSatisfaction) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;
        this.season = season;
        this.difficulty = difficulty;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.stockFood = stockFood;
        this.score = 0;
        this.globalSatisfaction = globalSatisfaction;

        factions = new ArrayList<Faction>();
    }

    public Island(String islandName, String dictatorName, String citizensName, int season, int difficulty, int agriculture, int stockFood, int industry, int treasury, int score, float globalSatisfaction) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;
        this.season = season;
        this.difficulty = difficulty;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.stockFood = stockFood;
        this.score = score;
        this.globalSatisfaction = globalSatisfaction;

        factions = new ArrayList<Faction>();
    }

    public String getIslandName() {
        return islandName;
    }

    public String getDictatorName() {
        return dictatorName;
    }

    public String getCitizensName() {
        return citizensName;
    }

    public int getSeason() {
        return season;
    }

    public int addSeason() {
        this.season+=1;
        if(this.season == 4){
            this.season = 0;
            score ++;
        }
        return season;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getAgriculture() {
        return agriculture;
    }

    public int getStockFood() {
        return stockFood;
    }

    public void addStockFood(int stockFood) {
        this.stockFood += stockFood;
    }

    public int getIndustry() {
        return industry;
    }

    public int getAccumulation(){
        return agriculture+industry;
    }

    public boolean isAccumulationMax(){
        if(getAccumulation() > 100){
            return true;
        }else{
            return false;
        }
    }

    public int getTreasury() {
        return treasury;
    }

    public int getScore() {
        return score;
    }

    public float getGlobalSatisfaction() {
        return globalSatisfaction;
    }

    public void addChoiceValue(NationType nationType, int value){
        if(nationType == NationType.agriculture){
            agriculture += value;
            if(isAccumulationMax()){
                industry -= value;
            }
        }else if(nationType == NationType.industry){
            industry += value;
            if(isAccumulationMax()){
                agriculture -= value;
            }
        }else if(nationType == NationType.treasury){
            treasury += value;
        }else {
            for (Faction faction:factions) {
                if(faction.getFactionType() == nationType){
                    faction.addSatisfaction(value);
                    break;
                }
            }
        }
    }

    public void setGlobalSatisfaction() {
        int satisfaction = 0;
        int globalSupporter = 0;

        for (Faction faction:factions) {
            satisfaction += faction.getSatisfactionCalculated();
            globalSupporter += faction.getSupporter();
        }

        this.globalSatisfaction = satisfaction/globalSupporter;
    }
}

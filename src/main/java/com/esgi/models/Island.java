package com.esgi.models;

import java.util.ArrayList;

public class Island {

    private final String islandName;
    private final String dictatorName;
    private final String citizensName;
    private int agriculture;
    private int stockFood;
    private int industry;
    private int treasury;
    private int score;
    private float globalSatisfaction;
    private ArrayList<Faction> factions;

    //new game Construct
    public Island(String islandName, String dictatorName, String citizensName, int agriculture, int stockFood, int industry, int treasury, float globalSatisfaction) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.stockFood = stockFood;
        this.score = 0;
        this.globalSatisfaction = globalSatisfaction;

        factions = new ArrayList<Faction>();
    }

    //load game Construct
    public Island(String islandName, String dictatorName, String citizensName, int agriculture, int stockFood, int industry, int treasury, int score, float globalSatisfaction, ArrayList<Faction> factions) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.stockFood = stockFood;
        this.score = score;
        this.globalSatisfaction = globalSatisfaction;

        this.factions = factions;
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

    private int removeAccumulation(){
        verifyAccumulation();

        int accumulation = getAccumulation() - 100;

        return accumulation;
    }

    private void verifyAccumulation(){
        if(agriculture > 100){
            agriculture =100;
        }else if(industry > 100){
            industry = 100;
        }
    }

    public boolean isAccumulationMax(){
        if(getAccumulation() > 100){
            return true;
        }else{
            return false;
        }
    }

    public void addScore(){
        score += 1;
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
                industry -= removeAccumulation();
            }
        }else if(nationType == NationType.industry){
            industry += value;
            if(isAccumulationMax()){
                agriculture -= removeAccumulation();
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

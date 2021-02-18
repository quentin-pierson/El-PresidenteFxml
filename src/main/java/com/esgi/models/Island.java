package com.esgi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@JsonIgnoreProperties({"accumulation", "accumulationMax", "citizen"})
public class Island {

    private String islandName;
    private String dictatorName;
    private String citizensName;
    private int agriculture;
    private int stockFood;
    private int industry;
    private int treasury;
    private int score;
    private float globalSatisfaction;
    private ArrayList<Faction> factions;

    public Island() {
        super();
    }

    //new game Construct
    public Island(String islandName, String dictatorName, String citizensName, int agriculture, int industry, int treasury, float globalSatisfaction) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.score = 0;
        this.globalSatisfaction = globalSatisfaction;

        factions = new ArrayList<Faction>();
    }

    //load game Construct
    public Island(String islandName, String dictatorName, String citizensName, int agriculture, int industry, int treasury, int score, float globalSatisfaction, ArrayList<Faction> factions) {
        this.islandName = islandName;
        this.dictatorName = dictatorName;
        this.citizensName = citizensName;

        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;

        this.score = score;
        this.globalSatisfaction = globalSatisfaction;

        this.factions = factions;
    }

    public void addFaction(Faction faction) {
        factions.add(faction);
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

    public int getAccumulation() {
        return agriculture + industry;
    }

    private int removeAccumulation() {
        verifyAccumulation();

        int accumulation = getAccumulation() - 100;

        return accumulation;
    }

    private void verifyAccumulation() {
        if (agriculture > 100) {
            agriculture = 100;
        } else if (industry > 100) {
            industry = 100;
        }
    }

    public boolean isAccumulationMax() {
        if (getAccumulation() > 100) {
            return true;
        } else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public int getTreasury() {
        return treasury;
    }

    public void endYear() {
        score += 1;
        treasury += industry * 10;
        stockFood += agriculture * 40;
        stockFood -= getCitizen() * 4;

        if (stockFood < 0) {
            killCitizen();
        } else {
            growCitizen();
        }
    }

    private void killCitizen() {
        Random random = new Random();
        int citizenKilled = 0;
        while (stockFood < 0) {
            int rnd = random.nextInt(factions.size());
            factions.get(rnd).addSupporter(-1);
            citizenKilled++;
            stockFood += 4;
        }

        int satisfactionDown = -2 * citizenKilled;

        for (Faction faction : factions) {
            faction.addSatisfaction(satisfactionDown);
        }

        stockFood = 0;
    }

    //FAIRE UN ALGO POUR QUE CA NE SOIT PAS ALEATOIRE
    private void growCitizen() {
        Random random = new Random();
        int percentCitizenTotal = random.nextInt(10) + 101;

        int newCitizen = getCitizen() * percentCitizenTotal / 100;

        while (stockFood < 0) {
            int rnd = random.nextInt(factions.size());
            int supporter = random.nextInt(newCitizen) + 1;

            factions.get(rnd).addSupporter(supporter);
            newCitizen -= supporter;
        }
    }

    public void buyFood() {
        if (treasury >= 8) {
            stockFood += 1;
            treasury -= 8;
        }
    }

    private void Corruption(int factionId) {
        Faction faction = factions.get(factionId);
        Faction loyalist = factions.stream().filter(f -> f.getFactionType() == NationType.loyalist).findFirst().orElse(null);

        int totalPrice = faction.getSupporter() * 15;
        if (treasury >= totalPrice) {
            faction.addSatisfaction(10);

            int loyalistSatisfaction = totalPrice / 10;

            loyalist.addSatisfaction(-loyalistSatisfaction);
            treasury -= totalPrice;
        }
    }

    public int getCitizen() {
        int citizen = 0;
        for (Faction faction : factions) {
            citizen += faction.getSupporter();
        }
        return citizen;
    }

    public float getGlobalSatisfaction() {
        return globalSatisfaction;
    }

    public void addChoiceValue(NationType nationType, int action) {
        if (nationType == NationType.agriculture) {
            agriculture += action;
            if (isAccumulationMax()) {
                industry -= removeAccumulation();
            }
            if(agriculture < 0){
                agriculture = 0;
            }

        } else if (nationType == NationType.industry) {
            industry += action;
            if (isAccumulationMax()) {
                agriculture -= removeAccumulation();
            }
            if(industry < 0){
                industry = 0;
            }

        } else if (nationType == NationType.treasury) {
            treasury += action;
        } else {
            for (Faction faction : factions) {
                if (faction.getFactionType() == nationType) {
                    faction.addSatisfaction(action);
                    break;
                }
            }
        }
    }

    public void choseChoice(Choice choice){
        for(Effect effect: choice.getEffects()){
            addChoiceValue(effect.getNationType(),effect.getAction());
        }
    }

    public void setGlobalSatisfaction() {
        int satisfaction = 0;
        int globalSupporter = 0;

        for (Faction faction : factions) {
            satisfaction += faction.getSatisfactionCalculated();
            globalSupporter += faction.getSupporter();
        }

        try {
            this.globalSatisfaction = satisfaction / globalSupporter;
        }catch (Exception ex){
            this.globalSatisfaction = 0;
        }
    }

}

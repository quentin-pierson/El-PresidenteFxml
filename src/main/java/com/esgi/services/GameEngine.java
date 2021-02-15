package com.esgi.services;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.models.Island;

public class GameEngine {
    Island island;

    Calamity calamity;

    public void initGame(){
        island = new Island("islandos","dictator","islander",0,0,15,200,15,200,50);
    }
    public void loadGame(){

    }

    public void setCalamity(){
        int time = island.addSeason();
        do{
            calamity = DataService.getInstance().getCalamity().isSeason(SeasonType.valueOf(time));
        }while (calamity == null);
    }
}

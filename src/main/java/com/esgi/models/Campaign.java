package com.esgi.models;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.services.DataService;

import java.util.ArrayList;

public class Campaign extends Game{
    private String name;
    private String description;

    private ArrayList<Calamity> calamities;

    private int progression;

    Campaign() {
        super();
        progression = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Calamity> getCalamities() {
        return calamities;
    }

    @Override
    public boolean setCalamity() {
        int time = addSeason();

        for(Island island :islands){
            island.setGlobalSatisfaction();
        }

        if(progression == calamities.size()){
            calamity = calamities.get(progression);
            progression++;
            return true;
        }else{
            return false;
        }
    }
}

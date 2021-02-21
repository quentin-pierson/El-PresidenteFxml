package com.esgi.models;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.services.DataService;

import java.util.ArrayList;

public class Campaign extends Game{
    private String name;

    private ArrayList<Calamity> calamities;

    private int progression;

    public Campaign() {
        super();
        progression = 0;
    }

    public Campaign(int season) {
        super(season);
        progression = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Calamity> getCalamities() {
        return calamities;
    }

    @Override
    public boolean setCalamity() {
        addSeason();

        for(Island island :islands){
            island.setGlobalSatisfaction();
        }

        if(progression != calamities.size()){
            calamity = calamities.get(progression);
            progression++;
            return true;
        }else{
            return false;
        }
    }
}

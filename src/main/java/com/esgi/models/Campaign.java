package com.esgi.models;

import com.esgi.models.Calamities.Calamity;

import java.util.ArrayList;

public class Campaign {
    private String name;
    private Game game;

    private ArrayList<Calamity> calamities;

    Campaign(){
        super();
    }

    public Game getGame(){
        return game;
    }
    public Calamity getCalamity(){
        return calamities.get(game.getTotalSeason());
    }

}

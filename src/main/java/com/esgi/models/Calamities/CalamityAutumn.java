package com.esgi.models.Calamities;

public class CalamityAutumn extends Calamity {
    public CalamityAutumn(String name, String description) {
        super(name, description);
    }
    @Override
    public Calamity isSeason(SeasonType seasonType){
        return seasonType == SeasonType.autumn ? this : null;
    }
}

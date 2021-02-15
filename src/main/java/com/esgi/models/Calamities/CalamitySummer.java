package com.esgi.models.Calamities;

public class CalamitySummer extends Calamity{
    public CalamitySummer(String name, String description) {
        super(name, description);
    }
    @Override
    public Calamity isSeason(SeasonType seasonType){
        return seasonType == SeasonType.summer ? this : null;
    }
}

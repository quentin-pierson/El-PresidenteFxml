package com.esgi.models.Calamities;

public class CalamityWinter extends Calamity{
    public CalamityWinter(String name, String description) {
        super(name, description);
    }
    @Override
    public Calamity isSeason(SeasonType seasonType){
        return seasonType == SeasonType.winter ? this : null;
    }
}

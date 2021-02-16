package com.esgi;

import com.esgi.models.Calamities.*;

import org.junit.Assert;
import org.junit.Test;

public class CalamityTest {
    @Test
    public void calamity_is_in_autumn_season_is_in_spring(){
        Calamity calamity = new CalamityAutumn("autumn","season is spring");
        SeasonType seasonType = SeasonType.spring;
        Assert.assertEquals(calamity.isSeason(seasonType), null);
    }

    @Test
    public void calamity_is_in_autumn(){
        Calamity calamity = new CalamityAutumn("autumn","season is autumn");
        SeasonType seasonType = SeasonType.autumn;
        Assert.assertEquals(calamity.isSeason(seasonType), calamity);
    }


    @Test
    public void calamity_is_in_winter_season(){
        Calamity calamity = new CalamityWinter("winter","season is winter");
        SeasonType seasonType = SeasonType.winter;
        Assert.assertEquals(calamity.isSeason(seasonType), calamity);
    }

    @Test
    public void calamity_is_in_summer_season(){
        Calamity calamity = new CalamitySummer("summer","season is summer");
        SeasonType seasonType = SeasonType.summer;
        Assert.assertEquals(calamity.isSeason(seasonType), calamity);
    }

    @Test
    public void calamity_is_in_spring_season(){
        Calamity calamity = new CalamitySpring("spring","season is spring");
        SeasonType seasonType = SeasonType.spring;
        Assert.assertEquals(calamity.isSeason(seasonType), calamity);
    }

}

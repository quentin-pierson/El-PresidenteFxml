package com.esgi;

import com.esgi.models.Island;
import com.esgi.models.NationType;
import org.junit.Assert;
import org.junit.Test;

public class IslandTest {
    @Test
    public void choice_value_is_treasury(){
        Island island = new Island("","","",20,0,20,100,0);
        island.addChoiceValue(NationType.treasury,10);
        Assert.assertEquals(island.getTreasury(), 110);
    }
    @Test
    public void choice_value_is_agriculture(){
        Island island = new Island("","","",20,0,20,100,0);
        island.addChoiceValue(NationType.agriculture,10);
        Assert.assertEquals(island.getAgriculture(), 30);
    }

    @Test
    public void choice_value_is_industry(){
        Island island = new Island("","","",20,0,20,100,0);
        island.addChoiceValue(NationType.industry,10);
        Assert.assertEquals(island.getIndustry(), 30);
    }

    @Test
    public void choice_value_is_industry_and_accumulation_is_max(){
        Island island = new Island("","","",70,0,30,100,0);
        island.addChoiceValue(NationType.industry,10);
        Assert.assertEquals(island.getIndustry(), 40);
        Assert.assertEquals(island.getAgriculture(), 60);
    }

    @Test
    public void choice_value_is_agriculture_and_accumulation_is_max(){
        Island island = new Island("","","",80,0,20,100,0);
        island.addChoiceValue(NationType.agriculture,10);
        Assert.assertEquals(island.getAgriculture(), 90);
        Assert.assertEquals(island.getIndustry(), 10);
    }

    @Test
    public void choice_value_is_industry_and_agriculture_is_null(){
        Island island = new Island("","","",20,0,80,100,0);
        island.addChoiceValue(NationType.industry,50);
        Assert.assertEquals(island.getIndustry(), 100);
        Assert.assertEquals(island.getAgriculture(), 0);
    }

    @Test
    public void choice_value_is_agriculture_and_industry_is_null(){
        Island island = new Island("","","",80,0,20,100,0);
        island.addChoiceValue(NationType.agriculture,50);
        Assert.assertEquals(island.getAgriculture(), 100);
        Assert.assertEquals(island.getIndustry(), 0);
    }

    @Test
    public void corruption(){

    }

    @Test
    public void corruption_with_no_treasury(){

    }

    @Test
    public void buy_food(){

    }

    @Test
    public void buy_food_with_no_treasury(){

    }

    @Test
    public void kill_citizen(){

    }
}

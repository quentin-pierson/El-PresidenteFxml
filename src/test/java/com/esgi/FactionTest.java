package com.esgi;

import com.esgi.models.Faction;
import com.esgi.models.NationType;
import org.junit.Assert;
import org.junit.Test;

public class FactionTest {
    @Test
    public void add_supporter(){
        Faction faction = new Faction("FactionTest",10, NationType.nationalist,10);
        faction.addSupporter(10);
        Assert.assertEquals(faction.getSupporter(),20);
    }
    @Test
    public void satisfaction_calculated(){
        Faction faction = new Faction("FactionTest",10, NationType.nationalist,10);
        Assert.assertEquals(faction.getSatisfactionCalculated(),100);
    }
}

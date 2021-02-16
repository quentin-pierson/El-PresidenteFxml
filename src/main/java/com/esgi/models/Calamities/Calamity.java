package com.esgi.models.Calamities;

import com.esgi.models.Choice;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Calamity.class, name = "calamity"),
        @Type(value = CalamityAutumn.class, name = "calamityAutumn"),
        @Type(value = CalamitySpring.class, name = "calamitySpring"),
        @Type(value = CalamitySummer.class, name = "CalamitySummer"),
        @Type(value = CalamityWinter.class, name = "CalamityWinter")
})

public class Calamity {
        private String name;
        private String description;
        ArrayList<Choice> choices;

        public Calamity()
        {
            super();
        }

        Calamity(String name, String description) {
            this.name = name;
            this.description = description;
            choices = new ArrayList<Choice>();
        }

        private String getName(){
            return name;
        }

        private String getDescription(){
            return description;
        }

        public Calamity isSeason(SeasonType seasonType){
            return this;
        }
    }


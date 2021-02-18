package com.esgi.models.Calamities;

import com.esgi.models.Choice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"choicesDisplay"})
public class Calamity {
    private String name;
    private String description;
    ArrayList<Choice> choices;

    public Calamity() {
        super();
    }

    Calamity(String name, String description) {
        this.name = name;
        this.description = description;
        choices = new ArrayList<Choice>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getChoicesDisplay() {
        ArrayList<String> effects = new ArrayList<String>();
        for(Choice choice: choices){
            effects.add(choice.display());
        }
        return effects;
    }

    public Calamity isSeason(SeasonType seasonType) {
        return this;
    }

}


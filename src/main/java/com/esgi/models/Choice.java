package com.esgi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

public class Choice {
    private String description;
    private int calamityChild;
    private ArrayList<Effect> effects;

    public Choice() {
        super();
    }

    public Choice(String description) {
        this.description = description;
        effects = new ArrayList<Effect>();
    }

    public String display() {
        String text = description + ":";

        for (Effect effect : effects) {
            text += " " + effect.display();
        }
        return text;
    }

    public int getCalamityChild() {
        return calamityChild;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }
}

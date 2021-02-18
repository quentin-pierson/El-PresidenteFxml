package com.esgi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"negative", "displayEffect"})
public class Effect {
    private int action;
    private NationType nationType;

    public Effect() {
        super();
    }

    public Effect(int action, NationType nationType) {
        this.action = action;
        this.nationType = nationType;
    }
    private boolean isNegative() { return action> 0; }

    public String display(){
        String text = "";

        if (isNegative()) {
            text += "+";
        }

        text += action;

        if (nationType == NationType.treasury) {
            text += "$";
        } else {
            text += "%";
        }
        text += " " + nationType;

        return text;
    }
}

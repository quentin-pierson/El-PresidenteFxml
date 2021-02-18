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
        String text = " " + nationType;

        if (isNegative()) {
            text += "+";
        }

        text += action;

        if (nationType == NationType.treasury) {
            text += "$,";
        } else {
            text += "%,";
        }

        return text;
    }

    public int getAction() {
        return action;
    }

    public NationType getNationType() {
        return nationType;
    }
}

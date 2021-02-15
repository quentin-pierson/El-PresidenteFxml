package com.esgi.models;

import java.util.ArrayList;

public class Choice {
    private final String description;
    private ArrayList<Effect> effects;

    public Choice(String description){
        this.description = description;
        effects = new ArrayList<Effect>();
    }

    public String display(){
        String text = description + " ";
        char valueType;
        for (Effect effect:effects) {
            if(effect.getValue() > 0){
                text += "+";
            }
            if(effect.getNationType() == NationType.treasury){
                valueType = '$';
            }else{
                valueType = '%';
            }
            text += effect.getValue() + valueType + " satisfaction of " + effect.getNationType();
        }
        return text;
    }

}

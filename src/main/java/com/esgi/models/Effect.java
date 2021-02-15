package com.esgi.models;

public class Effect {
    private int value;
    private NationType nationType;

    public Effect(int value, NationType nationType){
        this.value = value;
        this.nationType = nationType;
    }

    public int getValue(){
        return value;
    }

    public NationType getNationType(){
        return nationType;
    }
}

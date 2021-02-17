package com.esgi.models;

public class Parameter {
    private final int maxsize = 10;
    private boolean[] factionsOn = new boolean[maxsize];
    private int difficulty;

    public Parameter(){
        enableAll();
    }

    public void setDifficulty(int difficulty){ this.difficulty = difficulty;}

    public int getDifficulty() {
        return difficulty;
    }

    public void enableAll(){
        for (int i = 0; i < maxsize; i++){
            factionsOn[i] = true;
        }
    }

    public void setFactionOn(int i){
        factionsOn[i] = !factionsOn[i];
    }
}

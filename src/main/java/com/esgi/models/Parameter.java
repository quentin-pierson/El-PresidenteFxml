package com.esgi.models;

public class Parameter {
    private final int maxsize = 10;
    private boolean[] factionsOn = new boolean[maxsize];
    private boolean foodExpiration;
    private int difficulty;

    public Parameter() {
        super();
        enableAll();
    }

    public boolean getFactionOn(int i) {
        return factionsOn[i];
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setFoodExpiration(boolean foodExpiration) {
        this.foodExpiration = foodExpiration;
    }

    public boolean getFoodExpiration() {
        return foodExpiration;
    }

    public void enableAll() {
        for (int i = 0; i < maxsize; i++) {
            factionsOn[i] = true;
        }
    }

    public void setFactionOn(int i) {
        factionsOn[i] = !factionsOn[i];
    }
}

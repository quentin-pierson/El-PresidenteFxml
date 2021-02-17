package com.esgi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "factionType","satisfactionCalculated" })
public class Faction {
    private String name;
    private int satisfaction;
    private NationType nationType;
    private int supporter;

    public Faction()
    {
        super();
    }

    public Faction(String name, int satisfaction, NationType nationType, int supporter) {
        this.name = name;
        this.satisfaction = satisfaction;
        this.nationType = nationType;
        this.supporter = supporter;
    }

    public Faction(String name, int satisfaction, int nationType, int supporter) {
        this.name = name;
        this.satisfaction = satisfaction;
        this.nationType = NationType.valueOf(nationType);
        this.supporter = supporter;
    }

    public int getSupporter(){
        return supporter;
    }

    public void addSupporter(int supporter){
        this.supporter += supporter;
    }

    public int getSatisfactionCalculated(){
        return supporter * satisfaction;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void addSatisfaction(int satisfaction) {
        if(this.satisfaction != 0){
            this.satisfaction += satisfaction;

            if(this.satisfaction < 0){
                this.satisfaction = 0;
            }
        }
    }

    public String getName() {
        return name;
    }

    public NationType getFactionType() {
        return nationType;
    }
}

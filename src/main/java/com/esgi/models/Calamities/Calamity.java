package com.esgi.models.Calamities;

import com.esgi.models.Choice;

import java.util.ArrayList;

public class Calamity {
        private final String name;
        private final String description;
        ArrayList<Choice> choices;

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


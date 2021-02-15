package com.esgi.services;

import com.esgi.models.Calamities.Calamity;

import java.util.ArrayList;
import java.util.Random;

public class DataService {

    private static DataService instance;

    public static DataService getInstance(){
        if(instance == null){
            instance = new DataService();
        }
        return instance;
    }

    private ArrayList<Calamity> calamities = new ArrayList<Calamity>();

    public DataService(){

    }

    public Calamity getCalamity(){
        return arrayRandom(calamities);
    }

    public <T> T arrayRandom(ArrayList<T> list){
        Random random = new Random();
        int rnd = random.nextInt(list.size());
        T obj = list.get(rnd);

        return obj;
    }

}

package com.esgi.services;

import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Campaign;
import com.esgi.models.Game;

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

    private final String pathCalamities = "src/main/resources/com/esgi/data/calamities.json";
    private final String pathCampaigns = "src/main/resources/com/esgi/data/calamities.json";

    private ArrayList<Calamity> calamities = new ArrayList<Calamity>();
    private ArrayList<Campaign> campaigns = new ArrayList<Campaign>();

    public DataService(){
        calamities = DataManagement.getInstance().deserializeList(pathCalamities);
        campaigns = DataManagement.getInstance().deserializeList(pathCampaigns);
    }

    public Calamity getCalamity(){
        return arrayRandom(calamities);
    }

    public ArrayList<Campaign> getCampaigns(){ return campaigns;}

    public <T> T arrayRandom(ArrayList<T> list){
        Random random = new Random();
        int rnd = random.nextInt(list.size());
        T obj = list.get(rnd);

        return obj;
    }

}

package com.esgi.models;
import com.esgi.services.DataManagement;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Save {
    private ArrayList<Game> games;
    private final String path = "save.json";

    public Save(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        games = DataManagement.getInstance().deserializeList(path);

        if(games == null) games = new ArrayList<Game>();
    }

    public void saveGame(Game game){

        try{
            Game existGame = games.stream().filter(g -> g.getId() == game.getId()).findFirst().orElse(null);

            if(existGame != null){
                games.remove(existGame);
            }
        }catch (Exception ex){

        }

        games.add(game);

        DataManagement.getInstance().serialize(path, games);
    }

    public Game loadGame(int i){
        return games.get(i);
    }

    public int numberSave(){
        return games.size();
    }
}
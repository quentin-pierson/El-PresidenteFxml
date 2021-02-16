package com.esgi.models;
import org.codehaus.jackson.type.TypeReference;
import org.json.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Save {
    private ArrayList<Game> games;
    private final String path = "./data/save.json";

    public Save(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            games = mapper.readValue(new File(path), new TypeReference<ArrayList<Game>>(){});

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGame(Game game){
        ObjectMapper mapper = new ObjectMapper();
        games.add(game);

        try {
        mapper.writeValue(new File(path), games);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game loadGame(int i){
        return games.get(i);
    }
}

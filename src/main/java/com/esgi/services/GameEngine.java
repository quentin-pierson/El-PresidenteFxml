package com.esgi.services;
import com.esgi.models.Parameter;
import com.esgi.models.Save;
import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.models.Game;
import com.esgi.models.Island;

public class GameEngine {

    private Game game;

    private Save save;

    public GameEngine(){
        save = new Save();
    }

    public void createGame(){
        game = new Game();
        Parameter parameter = new Parameter();

        game.setParameter(parameter);
    }

    public void initGame(){
        Island island = new Island("islandos","dictator","islander",10,15,10,15,50);
        game.addIsland(island);
        game.setId(save.numberSave());
    }
    public void loadGame(int i){
        game = save.loadGame(i);
    }

    public Game getGame(){
        return game;
    }

    public void saveGame(){
        save.saveGame(game);
    }
}

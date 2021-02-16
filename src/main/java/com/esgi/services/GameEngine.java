package com.esgi.services;
import com.esgi.models.Save;
import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;
import com.esgi.models.Game;
import com.esgi.models.Island;

public class GameEngine {

    Game game;

    Calamity calamity;

    Save save;

    public GameEngine(){
        save = new Save();
    }

    public void initGame(){
        game = new Game(0);
        Island island = new Island("islandos","dictator","islander",10,15,10,15,50);
        game.addIsland(island);
    }
    public void loadGame(){

    }

    public void saveGame(){
        save.saveGame(game);
    }

    public void setCalamity(){
        int time = game.addSeason();
        do{
            calamity = DataService.getInstance().getCalamity().isSeason(SeasonType.valueOf(time));
        }while (calamity == null);
    }
}

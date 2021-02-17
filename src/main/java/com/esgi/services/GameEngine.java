package com.esgi.services;
import com.esgi.models.*;
import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Calamities.SeasonType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameEngine {

    private Game game;

    private Save save;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ChatServices chatServices;

    public GameEngine(){
        save = new Save();
    }

    public void createGame(){
        game = new Game(GameType.singlePlayer);
        Parameter parameter = new Parameter();

        game.setParameter(parameter);
    }

    public void initGame(){
        Island island = new Island("islandos","dictator","islander",10,15,10,15,50);
        game.addIsland(island);
        game.setId(save.numberSave());
        game.setFaction();
        game.setCalamity();
    }

    public void joinMultiplayer(String host){
        try{
            serverSocket = null;
            clientSocket = new Socket(host,5000);

            chatServices = new ChatServices();
            chatServices.Listen(clientSocket, serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateMultiplayer(){
        try{
            serverSocket = new ServerSocket(5000);
            clientSocket = serverSocket.accept();

            chatServices = new ChatServices();
            chatServices.Listen(clientSocket, serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

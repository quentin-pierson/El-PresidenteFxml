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

    public GameEngine() {
        save = new Save();
    }

    public void createGame() {
        game = new Game(-1);
        Parameter parameter = new Parameter();

        game.setParameter(parameter);
    }

    public boolean initGame(GameType gameType, String islandName, String dictatorName, String citizenName) {
        if (game.getParameter().minFaction()) {
            game.setGameType(gameType);
            Island island = new Island(islandName, dictatorName, citizenName, 10, 10, 15, 50);
            game.addIsland(island);
            game.setId(save.numberSave());
            game.setFaction();
            return true;
        }
        return false;
    }

    public void joinMultiplayer(String host) {
        try {
            serverSocket = null;
            clientSocket = new Socket(host, 5000);

            chatServices = new ChatServices();
            chatServices.Listen(clientSocket, serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateMultiplayer() {
        try {
            serverSocket = new ServerSocket(5000);
            clientSocket = serverSocket.accept();

            chatServices = new ChatServices();
            chatServices.Listen(clientSocket, serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame(int i) {
        game = save.loadGame(i);
    }

    public void setGame(Game game) {this.game = game;}

    public Game getGame() {
        return game;
    }

    public void saveGame() {
        save.saveGame(game);
    }

    public Save getSave() {
        return save;
    }
}

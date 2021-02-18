package com.esgi.controllers;

import com.esgi.App;

import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {
    @FXML ListView listViewGame = new ListView();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Game game : App.getGameEngine().getSave().getGames()) {
            if(App.getGameType() == game.getGameType()) listViewGame.getItems().add(game.toString());

        }
    }


    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }

    @FXML
    private void switchToCreateGame() throws IOException {
        App.setRoot("createGame");
    }


}

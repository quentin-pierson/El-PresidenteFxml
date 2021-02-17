package com.esgi.controllers;

import com.esgi.App;

import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {
    @FXML ListView<String> listViewGame = new ListView<String>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listViewGame.getItems().addAll(App.getGameEngine().getSave().getGames());

        for (Game game: App.getGameEngine().getSave().getGames()) {
            listViewGame.getItems().add(game.toString());
        }
    }

    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }



}

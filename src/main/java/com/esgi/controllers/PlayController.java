package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.GameType;
import javafx.fxml.FXML;

import java.io.IOException;

public class PlayController {

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }


    @FXML
    private void switchToMultiPlayer() throws IOException {
        App.setRoot("multiPlayer");
    }

    @FXML
    private void switchToCareer() throws IOException {
        App.setGameType(GameType.campaign);
        App.setRoot("loadGame");
    }

    @FXML
    private void switchToSandBox() throws IOException {
        App.setGameType(GameType.singlePlayer);
        App.setRoot("loadGame");
    }

}

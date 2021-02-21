package com.esgi.controllers;

import com.esgi.App;

import com.esgi.models.Choice;
import com.esgi.models.Game;
import com.esgi.models.GameType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {
    @FXML ListView listViewGame = new ListView();

    ArrayList<Integer> gameId  = new ArrayList<Integer>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Game game : App.getGameEngine().getSave().getGames()) {
            if(App.getGameType() == game.getGameType()){
                listViewGame.getItems().add(game.toString());
                gameId.add(game.getId());
            }

        }
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException {

        int number = listViewGame.getSelectionModel().getSelectedIndex();
        if(number >= 0){
            Game game = App.getGameEngine().getSave().getGame(gameId.get(number));
            if(game != null){
                App.getGameEngine().setGame(game);
                App.setRoot("gameLaunch");
            }
        }
    }

    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }

    @FXML
    private void switchToCreateGame() throws IOException {
        if(App.getGameType() == GameType.campaign) {
            App.setRoot("createCampaign");
        }else {
            App.setRoot("createGame");
        }

    }


}

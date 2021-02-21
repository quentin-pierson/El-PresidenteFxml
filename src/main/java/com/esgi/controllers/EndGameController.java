package com.esgi.controllers;

import com.esgi.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {
    @FXML
    Text textMessageEndGame;
    @FXML
    Text textDictatorName;
    @FXML
    Text textTime;
    @FXML
    Text textNameCampaign;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(App.getGameEngine().getVictory()){
            textMessageEndGame.setText("GG well play. You win");
        }
        else{
            textMessageEndGame.setText("You loose. You're a looser");
        }
        textDictatorName.setText(App.getGameEngine().getGame().getIsland(0).getDictatorName());
        textNameCampaign.setText("");
        textTime.setText("");
        App.getGameEngine().setGame(null);
    }


    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }



}

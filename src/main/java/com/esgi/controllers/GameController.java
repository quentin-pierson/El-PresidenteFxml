package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    ListView listViewGame = new ListView();

    @FXML
    Text textTreasure;
    @FXML
    Text textIndustry;
    @FXML
    Text textAgriculture;
    @FXML
    Text textFood;
    @FXML
    Text textSeason;
    @FXML
    Text textScore;
    @FXML
    Text textCalamities;
    @FXML
    Text textSatisfactionGlobal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initVal();
    }

    private void initVal(){
        Game game = App.getGameEngine().getGame();
        listViewGame.getItems().addAll(game.getCalamity().getChoicesDisplay());
        textTreasure.setText("Treasury: " + game.getIsland(0).getTreasury());
        textIndustry.setText("Industry: " + game.getIsland(0).getIndustry());
        textAgriculture.setText("Agriculture: " + game.getIsland(0).getAgriculture());
        textFood.setText("Food: " + game.getIsland(0).getStockFood());
        textSeason.setText("Season: " + game.getSeason());
        textScore.setText("Score: " + game.getIsland(0).getScore());
        textCalamities.setText(game.getCalamity().getName() + ": " + game.getCalamity().getDescription());
        textSatisfactionGlobal.setText("Global satisfaction: " + game.getIsland(0).getGlobalSatisfaction());
    }
}

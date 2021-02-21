package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.Calamities.Calamity;
import com.esgi.models.Choice;
import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    ListView listViewGame = new ListView();

    @FXML
    ListView listViewChat = new ListView();

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
    @FXML
    Text textCitizen;

    Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = App.getGameEngine().getGame();
        if (game.getCalamity() == null) game.setCalamity();

        try {
            initVal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initVal() throws IOException {

        App.getGameEngine().saveGame();
        listViewGame.getItems().removeAll();
        listViewGame.getItems().clear();

        float globalSatisfaction = game.getIsland(0).getGlobalSatisfaction();

        if (globalSatisfaction <= 0) endGame();

        listViewGame.getItems().addAll(game.getCalamity().getChoicesDisplay());
        textTreasure.setText("Treasury: " + game.getIsland(0).getTreasury());
        textIndustry.setText("Industry: " + game.getIsland(0).getIndustry());
        textAgriculture.setText("Agriculture: " + game.getIsland(0).getAgriculture());
        textFood.setText("Food: " + game.getIsland(0).getStockFood());
        textSeason.setText("Season: " + game.getSeasonType());
        textScore.setText("Score: " + game.getIsland(0).getScore());
        textCalamities.setText(game.getCalamity().getName() + ": " + game.getCalamity().getDescription());
        textSatisfactionGlobal.setText("Global satisfaction: " + globalSatisfaction);
        textCitizen.setText("Citizen: " + game.getIsland(0).getCitizen());
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException {

        int number = listViewGame.getSelectionModel().getSelectedIndex();
        if (number >= 0) {
            Choice choice = game.getCalamity().getChoice(number);

            String text = "Game console: Your choice is:" + choice.display();
            addChat(text);

            App.getGameEngine().getGame().getIsland(0).choseChoice(choice);
            game.setCalamity();
            initVal();
        }
    }

    public void addChat(String text) {
        listViewChat.getItems().add(text);
    }

    private void endGame() throws IOException {
        App.getGameEngine().getSave().removeGame(game);
        App.getGameEngine().setVictory(false);
        App.setRoot("endGame");
    }

    @FXML
    private void switchToMenu() throws IOException {
        App.getGameEngine().setGame(null);
        App.setRoot("menu");
    }
}

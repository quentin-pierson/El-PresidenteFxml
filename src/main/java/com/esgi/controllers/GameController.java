package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.*;
import com.esgi.models.Calamities.Calamity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    Button buttonPastYear;

    Game game;

    Boolean endYear = false;

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
        textCalamities.setText(game.getCalamity().getName() + ": " + game.getCalamity().getDescription());
        updateText();
    }

    private void updateText(){
        textTreasure.setText("Treasury: " + game.getIsland(0).getTreasury());
        textIndustry.setText("Industry: " + game.getIsland(0).getIndustry());
        textAgriculture.setText("Agriculture: " + game.getIsland(0).getAgriculture());
        textFood.setText("Food: " + game.getIsland(0).getStockFood());
        textSeason.setText("Season: " + game.getSeasonType());
        textScore.setText("Score: " + game.getIsland(0).getScore());
        textSatisfactionGlobal.setText("Global satisfaction: " + game.getIsland(0).getGlobalSatisfaction());
        textCitizen.setText("Citizen: " + game.getIsland(0).getCitizen());
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException {
        if(!endYear){
            changeSeason();
        }
        else{
            buyItem();
        }
    }

    private void changeSeason() throws IOException{
        int number = listViewGame.getSelectionModel().getSelectedIndex();
        if (number >= 0) {
            Choice choice = game.getCalamity().getChoice(number);

            String text = "Game console: Your choice is:" + choice.display();
            addChat(text);

            App.getGameEngine().getGame().getIsland(0).choseChoice(choice);
            game.setCalamity();
            if(game.getSeason()==0){
                initEndYear();
            }
            else{
                initVal();
            }

        }
    }
    private void initEndYear(){
        endYear = true;
        buttonPastYear.setVisible(true);

        App.getGameEngine().saveGame();
        listViewGame.getItems().removeAll();
        listViewGame.getItems().clear();

        textCalamities.setText("Its the end of year, buy as you want !");

        listViewGame.getItems().add("food = 8$");
        for(Faction faction:App.getGameEngine().getGame().getIsland(0).getFactions()){
            int totalPrice = faction.corruptionPrice();
            listViewGame.getItems().add(faction.getFactionType()+" +10% = "+totalPrice+"$ | Loyalist -= "+totalPrice/10+"%");
        }
        updateText();
    }

    private void buyItem(){
        int number = listViewGame.getSelectionModel().getSelectedIndex();
        if(number==0){
            App.getGameEngine().getGame().getIsland(0).buyFood();
        }
        else if (number>=1){
            App.getGameEngine().getGame().getIsland(0).corruption(number-1);
        }
        updateText();
    }

    @FXML
    private void handleContinue(MouseEvent arg0) throws IOException {
        endYear = false;
        buttonPastYear.setVisible(false);
        initVal();
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

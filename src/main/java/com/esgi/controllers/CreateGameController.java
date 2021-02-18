package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateGameController implements Initializable {
    @FXML TextField DictatorName;
    @FXML TextField IslandName;
    @FXML TextField CitizenName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.getGameEngine().createGame();
    }

    @FXML
    private void startGame(){
        App.getGameEngine().
    }

    @FXML
    private void switchToLoadGame() throws IOException {
        App.setRoot("loadGame");
    }

    @FXML
    private void checkBoxCommunism() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(0);
    }

    @FXML
    private void checkBoxCapitalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(1);
    }

    @FXML
    private void checkBoxLiberals() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(2);
    }

    @FXML
    private void checkBoxReligious() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(3);
    }

    @FXML
    private void checkBoxMilitarist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(4);
    }

    @FXML
    private void checkBoxEnvironmentalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(5);
    }

    @FXML
    private void checkBoxNationalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(6);
    }

    @FXML
    private void checkBoxLoyalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(7);
    }

    @FXML
    private void checkBoxRoyalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(8);
    }

    @FXML
    private void checkBoxFeminist() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(9);
    }




}

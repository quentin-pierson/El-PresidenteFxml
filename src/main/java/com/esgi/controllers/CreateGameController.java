package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateGameController implements Initializable {
    @FXML TextField DictatorName;
    @FXML TextField IslandName;
    @FXML TextField CitizenName;
    @FXML ChoiceBox difficulty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.getGameEngine().createGame();
    }

    @FXML
    private void startGame(){
        App.getGameEngine().initGame(App.getGameType(),IslandName.getText(),DictatorName.getText(),CitizenName.getText());
    }

    @FXML
    private void switchToLoadGame() throws IOException {
        App.setRoot("loadGame");
    }

    @FXML
    private void checkBoxCommunism() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(0);
    }

    @FXML
    private void checkBoxCapitalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(1);
    }

    @FXML
    private void checkBoxLiberals() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(2);
    }

    @FXML
    private void checkBoxReligious() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(3);
    }

    @FXML
    private void checkBoxMilitarist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(4);
    }

    @FXML
    private void checkBoxEnvironmentalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(5);
    }

    @FXML
    private void checkBoxNationalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(6);
    }

    @FXML
    private void checkBoxLoyalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(7);
    }

    @FXML
    private void checkBoxRoyalist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(8);
    }

    @FXML
    private void checkBoxFeminist() throws IOException{
        App.getGameEngine().getGame().getParameter().setFactionOn(9);
    }

    @FXML
    private void checkBoxFoodExpiration() throws IOException{
        App.getGameEngine().getGame().getParameter().setFoodExpiration();
    }

    @FXML
    private void chooseDifficulty() throws IOException{
        App.getGameEngine().getGame().getParameter().setDifficulty(difficulty.getSelectionModel().getSelectedIndex());
    }







}

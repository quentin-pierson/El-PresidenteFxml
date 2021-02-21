package com.esgi.controllers;

import com.esgi.App;
import com.esgi.models.Campaign;
import com.esgi.services.DataService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CampaignGameController implements Initializable {


    @FXML
    TextField DictatorName;
    @FXML
    TextField IslandName;
    @FXML
    TextField CitizenName;
    @FXML
    ChoiceBox difficulty;

    @FXML
    ChoiceBox campaignChoose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.getGameEngine().createGame();
        initCampaign();
    }

    @FXML
    private void startGame() throws IOException {
        int campaignId = campaignChoose.getSelectionModel().getSelectedIndex();
        if (App.getGameEngine().initGame(App.getGameType(), IslandName.getText(), DictatorName.getText(), CitizenName.getText(), campaignId))
            App.setRoot("gameLaunch");
    }

    @FXML
    private void switchToLoadGame() throws IOException {
        App.setRoot("loadGame");
    }

    @FXML
    private void chooseDifficulty() throws IOException {
        App.getGameEngine().getGame().getParameter().setDifficulty(difficulty.getSelectionModel().getSelectedIndex());
    }

    private void initCampaign(){
        for(Campaign campaign: DataService.getInstance().getCampaigns()){
            campaignChoose.getItems().add(campaign.getName());
        }

    }
}


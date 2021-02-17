package com.esgi.controllers;

import com.esgi.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class MultiplayerController {

    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }
}

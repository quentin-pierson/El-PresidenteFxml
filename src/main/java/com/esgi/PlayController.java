package com.esgi;

import javafx.fxml.FXML;
import java.io.IOException;

public class PlayController {

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    private void switchToSinglePlayer() throws IOException {
        App.setRoot("singlePlayer");
    }

    @FXML
    private void switchToMultiPlayer() throws IOException {
        App.setRoot("multiPlayer");
    }
}

package com.esgi.Controller;

import com.esgi.App;
import javafx.fxml.FXML;
import java.io.IOException;

public class PlayController {

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }


    @FXML
    private void switchToMultiPlayer() throws IOException {
        App.setRoot("multiPlayer");
    }
}

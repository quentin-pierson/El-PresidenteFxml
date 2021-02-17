package com.esgi;

import javafx.fxml.FXML;
import java.io.IOException;

public class PlayController {

    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }
}

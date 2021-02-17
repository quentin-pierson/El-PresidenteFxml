package com.esgi;

import javafx.fxml.FXML;

import java.io.IOException;

public class QuitController {

    @FXML
    private void switchToQuit() throws IOException {
        App.setRoot("quit");
    }
}

package com.esgi;

import java.io.IOException;
import javafx.fxml.FXML;

public class OptionController {

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
}

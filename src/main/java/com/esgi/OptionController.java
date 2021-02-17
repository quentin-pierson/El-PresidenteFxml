package com.esgi;

import java.io.IOException;
import javafx.fxml.FXML;

public class OptionController {

    @FXML
    private void switchToOption() throws IOException {
        App.setRoot("primary");
    }
}

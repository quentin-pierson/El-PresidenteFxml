package com.esgi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private void switchToOption() throws IOException {
        App.setRoot("option");
    }

    @FXML public Button buttonClose;

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void switchToPlay() throws IOException {
        App.setRoot("play");
    }


}

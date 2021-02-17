package com.esgi.Controller;

import java.io.IOException;

import com.esgi.App;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;


public class OptionController {
    @FXML Slider volumeSlider;

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    /*
    public void modificationVolume(){
        volumeSlider.setValue(mp.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }
    */

}

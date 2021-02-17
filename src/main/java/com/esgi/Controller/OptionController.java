package com.esgi.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.esgi.App;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;


public class OptionController implements Initializable {
    @FXML Slider volumeSlider;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        modificationVolume();
    }

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }


    private void modificationVolume(){
        volumeSlider.setValue(App.getMediaPlayer().getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                App.getMediaPlayer().setVolume(volumeSlider.getValue() / 100);
            }
        });
    }



}

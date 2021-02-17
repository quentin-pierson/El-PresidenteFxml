package com.esgi;

import com.esgi.services.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private GameEngine gameEngine;
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        gameEngine = new GameEngine();
        playMusic();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public void playMusic(){
        String pathMusic = "src/main/resources/com/esgi/Sound/MusicMain.mp3";
        Media h = new Media(new File(pathMusic).toURI().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.5d);
        mediaPlayer.play();
    }
}
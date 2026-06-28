package it.unicam.cs.mpgc.RPG122532;

import it.unicam.cs.mpgc.RPG122532.controller.GameParameterController;
import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        GameParameterController gameParameterController = new GameParameterController();
        if (gameParameterController.startNewGame()){
            //deve startare il gioco, caricando la intro
            SceneController sceneController = new SceneController();
            sceneController.StartFXML(primaryStage, 0);
        } else {
            //altrimenti, carica l'ultimo salvatggio
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

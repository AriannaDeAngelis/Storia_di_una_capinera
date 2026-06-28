package it.unicam.cs.mpgc.rpg122532;

import it.unicam.cs.mpgc.rpg122532.controller.GameParameterController;
import it.unicam.cs.mpgc.rpg122532.controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        GameParameterController gameParameterController = new GameParameterController();
        SceneController sceneController = new SceneController();
        if (gameParameterController.startNewGame()){
            //deve startare il gioco, caricando la intro
            sceneController.StartFXML(primaryStage, 0);
        } else {
            //altrimenti, carica l'ultimo salvatggio
            sceneController.StartFXML(primaryStage,gameParameterController.readParameter().getIDscene());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

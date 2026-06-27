package it.unicam.cs.mpgc.RPG122532;

import it.unicam.cs.mpgc.RPG122532.controller.GameParameterController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameParameterController gameParameterController = new GameParameterController()
        if (gameParameterController.startNewGame()){
            //deve startare il gioco, caricando la intro
        } else {
            //altrimenti, carica l'ultimo salvatggio
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

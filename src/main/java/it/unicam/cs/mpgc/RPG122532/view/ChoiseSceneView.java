package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class ChoiseSceneView {
    //TODO change image, text, background
    //usare metodo di init, metodo per i bottoni, label
    private Label choiceLabel;
    private SceneController sceneController;
    private

    public void init(SceneController sceneController, int ID){
        this.sceneController = sceneController;
        this.sceneData = sceneController.readScene(ID);

    }

}

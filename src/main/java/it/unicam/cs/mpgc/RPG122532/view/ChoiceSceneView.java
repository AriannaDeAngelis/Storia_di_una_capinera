package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import it.unicam.cs.mpgc.RPG122532.model.Choice;
import it.unicam.cs.mpgc.RPG122532.model.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

public class ChoiceSceneView {
    //TODO change image, text, background
    //usare metodo di init, metodo per i bottoni, label

    private SceneController sceneController;
    //private Choice sceneData;

    private Label choiceLabel;
    private ImageView choiceImage;
    private AnchorPane backgroundPane;

    private Button buttonChoice;
    private Scene sceneData;


    public void init(SceneController sceneController, int ID){
          this.sceneController = sceneController;
          this.sceneData = sceneController.readScene(ID);



    }


}

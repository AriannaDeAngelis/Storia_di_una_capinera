package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;

public class HorrorSceneView {
    private List<String> textList = new ArrayList<>();
    private Label sceneLabel;
    private int currentText;

    public void init(SceneController sceneController, int ID){
        currentText = 0;
        this.textList = sceneController.readScene(ID).getTextList();
        sceneLabel.setText(textList.get(currentText));
    }

    @FXML
    public void clickForward(javafx.event.ActionEvent event){
        currentText += 1;
        if (currentText < textList.size()){
            sceneLabel.setText(textList.get(currentText));
        } else {
            //TODO implementare fine scrittura testi

        }
    }
}

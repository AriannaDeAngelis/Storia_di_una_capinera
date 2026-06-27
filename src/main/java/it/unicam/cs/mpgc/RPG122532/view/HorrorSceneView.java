package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.plaf.synth.Region;
import java.io.IOException;
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
    public void clickForward(javafx.event.ActionEvent event) throws IOException {
        currentText += 1;
        if (currentText < textList.size()){
            sceneLabel.setText(textList.get(currentText));
        } else {
            ChangeScene(event);
        }
    }

    private void ChangeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scene/choice-scene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1200, 800);
        /*if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }*/
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}

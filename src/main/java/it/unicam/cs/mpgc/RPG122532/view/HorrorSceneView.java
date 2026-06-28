package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.ChoiceController;
import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import it.unicam.cs.mpgc.RPG122532.model.Choice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HorrorSceneView {
    private List<String> textList = new ArrayList<>();
    private int currentText;
    private int currentScene;
    @FXML
    private Text storyText;

    @FXML
    private ImageView backgroundImage;

    public void init(SceneController sceneController, int ID){
        currentText = 0;
        currentScene = ID;
        it.unicam.cs.mpgc.RPG122532.model.Scene sceneData = sceneController.readScene(ID);
        this.textList = sceneData.getTextList();
        storyText.setText(textList.get(currentText));
        loadBackground(sceneData.getImage());
    }

    private void loadBackground(String image) {
        if (image == null || image.isBlank()) {
            return;
        }
        var url = getClass().getResource(image);
        if (url != null) {
            backgroundImage.setImage(new Image(url.toExternalForm()));
        }
    }

    @FXML
    public void clickForward(ActionEvent event) throws IOException {
        currentText += 1;
        if (currentText < textList.size()){
            storyText.setText(textList.get(currentText));
        } else {
            ChangeScene(event);
        }
    }

    private void ChangeScene(ActionEvent event) throws IOException {
        ChoiceController choiceController = new ChoiceController();
        List<Choice> choices = choiceController.readChoice(currentScene);


        if(choices==null || choices.isEmpty()){
            SceneController sceneController = new SceneController();
            sceneController.StartFXML((Stage) ((Node) event.getSource()).getScene().getWindow(),currentScene+1);
        } else {
            choiceController.StartFXML((Stage) ((Node) event.getSource()).getScene().getWindow(),currentScene);
        }
    }
}

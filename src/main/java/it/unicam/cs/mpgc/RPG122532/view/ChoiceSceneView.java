package it.unicam.cs.mpgc.RPG122532.view;

import it.unicam.cs.mpgc.RPG122532.controller.ChoiceController;
import it.unicam.cs.mpgc.RPG122532.controller.GameParameterController;
import it.unicam.cs.mpgc.RPG122532.controller.SceneController;
import it.unicam.cs.mpgc.RPG122532.model.Choice;
import it.unicam.cs.mpgc.RPG122532.model.GameParameter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Controller della scena delle scelte.
 *
 * I tre bottoni sono iniettati da {@code choice-scene.fxml} tramite fx:id e il
 * loro testo viene impostato in {@link #init} con i messaggi delle scelte della
 * scena. I bottoni senza una scelta corrispondente vengono nascosti.
 */
public class ChoiceSceneView {
    private List<Choice> choices;

    @FXML
    private Button option1Button;
    @FXML
    private Button option2Button;
    @FXML
    private Button option3Button;

    /**
     * Popola i testi dei tre bottoni con i messaggi delle scelte della scena.
     * I bottoni senza una scelta corrispondente vengono nascosti.
     */
    public void init(ChoiceController choiceController, int IDScene) {
        choices = choiceController.readChoice(IDScene);
        showChoice(option1Button, 0);
        showChoice(option2Button, 1);
        showChoice(option3Button, 2);
    }

    private void showChoice(Button button, int index) {
        boolean present = choices != null && index < choices.size();
        button.setText(present ? choices.get(index).getMessage() : "");
        button.setVisible(present);
        button.setManaged(present);
    }

    @FXML
    private void onOptionClicked(ActionEvent event) throws IOException {
        // TODO: applicare gli effetti della scelta e passare alla scena successiva
        int currentChoice = 0;
        Node sorgente = (Node) event.getSource();
        switch (sorgente.getId()){
            case "option1Button":
                currentChoice = 0;
                break;

            case "option2Button":
                currentChoice = 1;
                break;

            case "option3Button":
                currentChoice = 2;
                break;
        }
        GameParameterController gameParameter = new GameParameterController();
        gameParameter.setParameter(choices.get(currentChoice));
        ChangeScene(event, choices.get(currentChoice).getNextScene());
    }

    private void ChangeScene(ActionEvent event, int nextID) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.StartFXML((Stage) ((Node) event.getSource()).getScene().getWindow(),nextID);
    }
}

package it.unicam.cs.mpgc.rpg122532.controller;

import it.unicam.cs.mpgc.rpg122532.model.Choice;
import it.unicam.cs.mpgc.rpg122532.navigation.SceneNavigator;
import it.unicam.cs.mpgc.rpg122532.repository.ChoiceRepository;
import it.unicam.cs.mpgc.rpg122532.repository.GsonChoiceRepository;
import it.unicam.cs.mpgc.rpg122532.view.ChoiceSceneView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ChoiceController {
    private static final String FILE_PATH = "src/main/resources/File/choice.json";

    private final ChoiceRepository choiceRepository;
    private final SceneNavigator navigator;

    public ChoiceController() {
        this(new GsonChoiceRepository(FILE_PATH), new SceneNavigator());
    }

    public ChoiceController(ChoiceRepository choiceRepository, SceneNavigator navigator) {
        this.choiceRepository = choiceRepository;
        this.navigator = navigator;
    }

    public List<Choice> readChoice(int IDscene) {
        return choiceRepository.findByScene(IDscene);
    }

    public void StartFXML(Stage stage, int IDScene) throws IOException {
        navigator.switchTo(stage, "/Scene/choice-scene.fxml", "Direttore d'Ospedale", loader -> {
            ChoiceSceneView choiceSceneView = loader.getController();
            choiceSceneView.init(this, IDScene);
        });
    }
}

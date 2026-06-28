package it.unicam.cs.mpgc.rpg122532.controller;

import it.unicam.cs.mpgc.rpg122532.model.Scene;
import it.unicam.cs.mpgc.rpg122532.navigation.SceneNavigator;
import it.unicam.cs.mpgc.rpg122532.repository.GsonSceneRepository;
import it.unicam.cs.mpgc.rpg122532.repository.SceneRepository;
import it.unicam.cs.mpgc.rpg122532.view.HorrorSceneView;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private static final String FILE_PATH = "src/main/resources/File/scene.json";

    private final SceneRepository sceneRepository;
    private final SceneNavigator navigator;

    public SceneController() {
        this(new GsonSceneRepository(FILE_PATH), new SceneNavigator());
    }

    public SceneController(SceneRepository sceneRepository, SceneNavigator navigator) {
        this.sceneRepository = sceneRepository;
        this.navigator = navigator;
    }

    public Scene readScene(int IDscene) {
        return sceneRepository.findById(IDscene);
    }

    public void StartFXML(Stage stage, int IDScene) throws IOException {
        navigator.switchTo(stage, "/Scene/horror-scene.fxml", "Direttore d'Ospedale", loader -> {
            HorrorSceneView horrorSceneView = loader.getController();
            horrorSceneView.init(this, IDScene);
        });
    }
}

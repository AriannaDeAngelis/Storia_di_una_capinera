package it.unicam.cs.mpgc.RPG122532.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122532.model.Scene;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneController {
    private static final String FILE_PATH = "src/main/resources/File/scene.json";

    /** Istanza Gson configurata per output formattato */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public Scene readScene(int IDscene){
        try (FileReader reader = new FileReader(FILE_PATH)) {
            var listType = new TypeToken<List<Scene>>(){}.getType();
            List<Scene> scenes = GSON.fromJson(reader, listType);
            Scene requestScene = scenes.stream()
                                       .filter(u -> u.getIDscene() == IDscene)
                                       .findFirst()
                                       .orElse(null);
            return requestScene;

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file scene: " + e.getMessage());
            return null;
        }
    }

}

package it.unicam.cs.mpgc.rpg122532.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.rpg122532.model.Scene;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public final class GsonSceneRepository implements SceneRepository {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final String filePath;

    public GsonSceneRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Scene findById(int id) {
        try (FileReader reader = new FileReader(filePath)) {
            var listType = new TypeToken<List<Scene>>() {}.getType();
            List<Scene> scenes = GSON.fromJson(reader, listType);
            return scenes.stream()
                    .filter(s -> s.getIDscene() == id)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file scene: " + e.getMessage());
            return null;
        }
    }
}

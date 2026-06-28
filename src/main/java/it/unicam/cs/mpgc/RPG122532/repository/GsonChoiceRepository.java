package it.unicam.cs.mpgc.RPG122532.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122532.model.Choice;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public final class GsonChoiceRepository implements ChoiceRepository {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final String filePath;

    public GsonChoiceRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Choice> findByScene(int sceneId) {
        try (FileReader reader = new FileReader(filePath)) {
            var listType = new TypeToken<List<Choice>>() {}.getType();
            List<Choice> choices = GSON.fromJson(reader, listType);
            return choices.stream()
                    .filter(c -> c.getIDscene() == sceneId)
                    .toList();
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file choice: " + e.getMessage());
            return null;
        }
    }
}

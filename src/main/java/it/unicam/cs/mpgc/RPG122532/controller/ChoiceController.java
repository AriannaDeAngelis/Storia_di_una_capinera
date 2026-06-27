package it.unicam.cs.mpgc.RPG122532.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import it.unicam.cs.mpgc.RPG122532.model.Choice;

public class ChoiceController {
    private static final String FILE_PATH = "src/main/resources/File/choice.json";

    /** Istanza Gson configurata per output formattato */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public Choice readChoice(int IDchoice) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            var listType = new TypeToken<List<Choice>>() {
            }.getType();
            List<Choice> choices = GSON.fromJson(reader, listType);
            Choice requestChoice = choices.stream()
                    .filter(u -> u.getIDchoice() == IDchoice)
                    .findFirst()
                    .orElse(null);
            return requestChoice;

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file choice: " + e.getMessage());
            return null;
        }
    }
}

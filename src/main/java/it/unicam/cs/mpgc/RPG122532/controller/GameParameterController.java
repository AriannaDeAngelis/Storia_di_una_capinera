package it.unicam.cs.mpgc.RPG122532.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122532.model.Choice;
import it.unicam.cs.mpgc.RPG122532.model.GameParameter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GameParameterController {
    private static final String FILE_PATH = "src/main/resources/File/GameParameter.json";

    /** Istanza Gson configurata per output formattato */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public GameParameter readParameter() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            var listType = new TypeToken<GameParameter>() {
            }.getType();
            GameParameter parameters = GSON.fromJson(reader, listType);
            return parameters;

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file choice: " + e.getMessage());
            return null;
        }
    }

    public boolean startNewGame(){
        GameParameter gameParameter = readParameter();
        if (gameParameter == null){
            return true;
        } else {
            return false;
        }
    }
}

package it.unicam.cs.mpgc.RPG122532.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.mpgc.RPG122532.model.GameParameter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class GsonParameterStore implements ParameterStore {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final String filePath;

    public GsonParameterStore(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public GameParameter load() {
        try (FileReader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, GameParameter.class);
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file parametri: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(GameParameter parameter) {
        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(parameter, writer);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dei parametri: " + e.getMessage());
        }
    }
}

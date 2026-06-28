package it.unicam.cs.mpgc.RPG122532.controller;

import it.unicam.cs.mpgc.RPG122532.model.Choice;
import it.unicam.cs.mpgc.RPG122532.model.GameParameter;
import it.unicam.cs.mpgc.RPG122532.repository.GsonParameterStore;
import it.unicam.cs.mpgc.RPG122532.repository.ParameterStore;

public class GameParameterController {
    private static final String FILE_PATH = "src/main/resources/File/GameParameter.json";

    private final ParameterStore parameterStore;

    public GameParameterController() {
        this(new GsonParameterStore(FILE_PATH));
    }

    public GameParameterController(ParameterStore parameterStore) {
        this.parameterStore = parameterStore;
    }

    public GameParameter readParameter() {
        return parameterStore.load();
    }

    public boolean startNewGame() {
        GameParameter gameParameter = readParameter();
        if (gameParameter == null) {
            gameParameter = new GameParameter();
            parameterStore.save(gameParameter);
            return true;
        } else {
            return false;
        }
    }

    public void setParameter(Choice choice) {
        GameParameter gameParameter = readParameter();
        gameParameter.setHealt(gameParameter.getHealt() + choice.getAlterHealt());
        gameParameter.setWill(gameParameter.getWill() + choice.getAlterWill());
        gameParameter.setResignation(gameParameter.getResignation() + choice.getAlterResignation());
        gameParameter.setIDscene(choice.getNextScene());
        parameterStore.save(gameParameter);
    }
}

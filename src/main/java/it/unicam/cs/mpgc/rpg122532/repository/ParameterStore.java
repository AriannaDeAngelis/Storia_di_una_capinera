package it.unicam.cs.mpgc.rpg122532.repository;

import it.unicam.cs.mpgc.rpg122532.model.GameParameter;

public interface ParameterStore {
    GameParameter load();

    void save(GameParameter parameter);
}

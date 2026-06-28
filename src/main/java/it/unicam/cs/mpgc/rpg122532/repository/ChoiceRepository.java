package it.unicam.cs.mpgc.rpg122532.repository;

import it.unicam.cs.mpgc.rpg122532.model.Choice;

import java.util.List;

public interface ChoiceRepository {
    List<Choice> findByScene(int sceneId);
}

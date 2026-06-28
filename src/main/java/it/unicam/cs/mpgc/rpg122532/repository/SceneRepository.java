package it.unicam.cs.mpgc.rpg122532.repository;

import it.unicam.cs.mpgc.rpg122532.model.Scene;

public interface SceneRepository {
    Scene findById(int id);
}

package it.unicam.cs.mpgc.RPG122532.repository;

import it.unicam.cs.mpgc.RPG122532.model.Scene;

public interface SceneRepository {
    Scene findById(int id);
}

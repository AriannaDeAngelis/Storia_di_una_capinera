package it.unicam.cs.mpgc.RPG122532.model;

import java.util.List;

public class Scene {
    public final String id, text;
    public final List<Choice> choices;

    public Scene(String id, String text, List<Choice> choices) {
        this.id = id; this.text = text; this.choices = choices;
    }
}
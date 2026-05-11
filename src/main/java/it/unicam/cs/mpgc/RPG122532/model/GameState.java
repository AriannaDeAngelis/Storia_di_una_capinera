package it.unicam.cs.mpgc.RPG122532.model;


import java.util.*;
import java.util.function.Consumer;

public class GameState {
    private int volonta = 40;
    private int rassegnazione = 40;
    private int salute = 100;
    private Map<String, Boolean> flags = new HashMap<>();
    private String currentSceneId = "scena_1";

    public void setFlag(String key, boolean value) { flags.put(key, value); }
    public boolean getFlag(String key) { return flags.getOrDefault(key, false); }

    public void modifyStats(int v, int r, int s) {
        volonta = Math.max(0, Math.min(100, volonta + v));
        rassegnazione = Math.max(0, Math.min(100, rassegnazione + r));
        salute = Math.max(0, Math.min(100, salute + s));
    }

    public String getCurrentSceneId() { return currentSceneId; }
    public void setCurrentSceneId(String id) { this.currentSceneId = id; }

    public boolean canShow(Choice c) {
        if (c.requiredFlag != null && !flags.getOrDefault(c.requiredFlag, false)) return false;
        return true;
    }

    public String checkEnding() {
        if (rassegnazione >= 60 && salute <= 30) return "MACABRO";
        if (volonta >= 60 && getFlag("alleanza_marta") && salute > 40) return "LIETO";
        return "MACABRO_FALLBACK";
    }
}


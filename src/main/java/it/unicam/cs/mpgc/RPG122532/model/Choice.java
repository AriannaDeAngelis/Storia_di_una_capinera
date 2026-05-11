package it.unicam.cs.mpgc.RPG122532.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Choice {
    public final String text;
    public final String requiredFlag;
    public final int dVolonta, dRassegnazione, dSalute;
    public final String nextSceneId;

    public Choice(String text, String requiredFlag, int v, int r, int s, String next) {
        this.text = text; this.requiredFlag = requiredFlag;
        this.dVolonta = v; this.dRassegnazione = r; this.dSalute = s; this.nextSceneId = next;
    }
}




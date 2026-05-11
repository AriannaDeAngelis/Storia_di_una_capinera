package it.unicam.cs.mpgc.RPG122532.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryRepository {
    private static Map<String, Scene> scenes = new HashMap<>();

    static {
        scenes.put("scena_1", new Scene("scena_1",
                "Un biglietto trema sotto la porta. \"Nel buio del lazzaretto, ho visto solo te.\"",
                List.of(
                        new Choice("Nascondi la lettera nel breviario", null, 0, 10, 0, "scena_2"),
                        new Choice("Affidala a Marta: \"Portagliela\"", "alleanza_marta_false", 10, 0, -5, "scena_2") {
                            { setFlagOnSelect("alleanza_marta", true); }
                            private void setFlagOnSelect(String k, boolean v) { /* handled by controller */ }
                        },
                        new Choice("Brucia l'angolo del foglio", null, -5, 5, -10, "scena_2")
                )
        ));

        scenes.put("scena_2", new Scene("scena_2",
                "La febbre sale. La Madre Superiora: \"Accetta la grazia del dolore. Ti salverà.\"",
                List.of(
                        new Choice("Mi inchino. Non voglio più scegliere.", null, 0, 15, -5, "scena_3"),
                        new Choice("Pronuncio il suo nome: Nino", "incontro_segreto", 15, -5, 0, "scena_3"),
                        new Choice("Fisso il crocifisso in silenzio.", null, 5, 5, -10, "scena_3")
                )
        ));

        scenes.put("scena_3", new Scene("scena_3",
                "La porta è socchiusa. La chiave è sotto il mattone scrostato.",
                List.of(
                        new Choice("Segui Marta nel corridoio", "alleanza_marta", 20, 0, -5, null), // null = ending check
                        new Choice("Riponi la chiave. Torni in cella.", null, 0, 20, -10, null)
                )
        ));
    }

    public static Scene getScene(String id) { return scenes.get(id); }
    public static List<String> getSceneIds() { return new ArrayList<>(scenes.keySet()); }
}
package it.unicam.cs.mpgc.RPG122532.model;

public class Choice {
    //azioni
    private int IDchoice;
    private int IDscene;
    private String message;
    private String nextScene;
    private int alterWill;
    private int alterHealt;
    private int alterResignation;

    public int getIDchoice() {
        return IDchoice;
    }

    public void setIDchoice(int IDchoice) {
        this.IDchoice = IDchoice;
    }

    public int getIDscene() {
        return IDscene;
    }

    public void setIDscene(int IDscene) {
        this.IDscene = IDscene;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNextScene() {
        return nextScene;
    }

    public void setNextScene(String nextScene) {
        this.nextScene = nextScene;
    }

    public int getAlterWill() {
        return alterWill;
    }

    public void setAlterWill(int alterWill) {
        this.alterWill = alterWill;
    }

    public int getAlterHealt() {
        return alterHealt;
    }

    public void setAlterHealt(int alterHealt) {
        this.alterHealt = alterHealt;
    }

    public int getAlterResignation() {
        return alterResignation;
    }

    public void setAlterResignation(int alterResignation) {
        this.alterResignation = alterResignation;
    }
}

package it.unicam.cs.mpgc.rpg122532.model;

public class GameParameter {
    //will, resignation, health = volontà, rassegnazione, salute del personaggio
    private int will;
    private int resignation;
    private int healt;
    private int IDscene; //salvo anche la scena corrente in caso il gioco si chiuda

    public GameParameter (){
        int will = 50;
        int healt = 50;
        int resignation = 50;
    }
    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getResignation() {
        return resignation;
    }

    public void setResignation(int resignation) {
        this.resignation = resignation;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getIDscene() {
        return IDscene;
    }

    public void setIDscene(int IDscene) {
        this.IDscene = IDscene;
    }
}

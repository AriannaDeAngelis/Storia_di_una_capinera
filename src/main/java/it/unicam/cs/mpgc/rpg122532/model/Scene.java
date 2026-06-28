package it.unicam.cs.mpgc.rpg122532.model;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private int IDscene;
    private List<String> textList = new ArrayList<>();
    private String image;

    public int getIDscene() {
        return IDscene;
    }

    public void setIDscene(int IDscene) {
        this.IDscene = IDscene;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

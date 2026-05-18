package it.unicam.cs.mpgc.RPG122532;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HorrorSceneController {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Label titleLabel;

    @FXML
    private Text storyText;

    @FXML
    private Button playButton;

    @FXML
    private void initialize() {
        setBackground("/Immagini/Immagine1.jpeg");
    }

    /**
     * Cambia l'immagine di sfondo della scena.
     * @param resourcePath percorso della risorsa (es. "/images/sfondo.jpg")
     */
    public void setBackground(String resourcePath) {
        Image img = new Image(getClass().getResourceAsStream(resourcePath));
        backgroundImage.setImage(img);
    }

    @FXML
    private void onPlayClicked() {
        // TODO: implementare la logica di avvio/proseguimento
        System.out.println("Play premuto");
    }
}

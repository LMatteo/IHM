package enseigne.customerController.galerie;

import enseigne.modele.photo.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class PhotoControl {

    @FXML
    private ImageView image;

    @FXML
    private Label description;

    @FXML
    private Label title;

    public void setPhoto(Photo p){
        title.setText(p.getTitreFr());
        description.setText(p.getDescriptionFr());
        File f = new File(p.getPhoto());
        Image i = new Image(f.toURI().toString());
        image.setImage(i);
    }


}
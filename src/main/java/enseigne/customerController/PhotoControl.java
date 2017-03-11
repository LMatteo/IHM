package enseigne.customerController;

import enseigne.modele.photo.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    }

}
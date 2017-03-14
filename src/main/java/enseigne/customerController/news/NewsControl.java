package enseigne.customerController.news;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewsControl {

    @FXML
    private ImageView view;

    public void setImage(Image i){
        view.setImage(i);
    }

}

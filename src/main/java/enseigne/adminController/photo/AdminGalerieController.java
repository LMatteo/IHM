package enseigne.adminController.photo;

import enseigne.ToNode;
import enseigne.modele.modele.PhotoFilter;
import enseigne.modele.photo.Photo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class AdminGalerieController {

    @FXML
    private ChoiceBox<?> categoriesBox;

    @FXML
    private TextField searchField;

    @FXML
    private VBox displayPane;

    public void update() throws IOException {
        displayPane.getChildren().clear();
        List<Photo> list = getPhotoList();
        for(Photo p : list){
            displayPane.getChildren().add(ToNode.photos(p));
        }
    }

    public List<Photo> getPhotoList() throws IOException {
        return(new PhotoFilter().toDisplay());
    }

    @FXML
    void searchButton(ActionEvent event) {

    }

}

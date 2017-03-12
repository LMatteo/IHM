package enseigne.customerController.galerie;

import enseigne.ToNode;
import enseigne.modele.modele.PhotoFilter;
import enseigne.modele.photo.Photo;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class GallerieController {
    @FXML
    private VBox pane;

    private PhotoFilter filter;

    @FXML
    public void initialize() throws IOException{
        filter = new PhotoFilter();
        update();
    }

    public void update() throws IOException {
        pane.getChildren().clear();
        List<Photo> photos = filter.toDisplay();
        for(Photo photo : photos){
            pane.getChildren().add(ToNode.photos(photo));
        }
    }

}

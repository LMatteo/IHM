package enseigne.customerController;

import enseigne.ToNode;
import enseigne.modele.actu.Actu;
import enseigne.modele.modele.ActuFilter;
import enseigne.modele.modele.PhotoFilter;
import enseigne.modele.photo.Photo;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class ActusController {

    @FXML
    private VBox pane;

    private ActuFilter filter;

    @FXML
    public void initialize() throws IOException {
        filter = new ActuFilter();
        update();
    }

    public void update(){
        pane.getChildren().clear();
        List<Actu> actus = filter.toDisplay();
        for(Actu actu : actus){
            pane.getChildren().add(ToNode.actu(actu));
        }
    }
}

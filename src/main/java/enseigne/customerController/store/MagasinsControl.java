package enseigne.customerController.store;

import enseigne.ToNode;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class MagasinsControl {

    @FXML
    private VBox pane;

    private MagFilter filter;

    @FXML
    public void initialize() throws IOException {
        filter = new MagFilter();
        update();
    }

    public void update() throws IOException{
        pane.getChildren().clear();
        List<Magasin> mags = filter.toDisplay();
        for(Magasin mag : mags){
            pane.getChildren().add(ToNode.magasins(mag,null));
        }
    }

}

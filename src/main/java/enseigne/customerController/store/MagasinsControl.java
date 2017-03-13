package enseigne.customerController.store;

import enseigne.ToNode;
import enseigne.adminController.store.MagCell;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class MagasinsControl {

    @FXML
    ListView<Magasin> view;

    MagFilter filter;

    @FXML
    public void initialize() throws IOException {
        filter = new MagFilter();
        view.setItems(filter.toDisplay());
        view.setCellFactory((ListView<Magasin> mag ) -> new MagCell());
        view.setFocusTraversable( false );
    }
}

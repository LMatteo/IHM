package enseigne.customerController.store;

import enseigne.adminController.store.MagCell;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MagasinsControl {

    @FXML
    ListView<Magasin> view;
    @FXML
    TextField field;
    @FXML
    Button button;
    MagFilter filter;

    @FXML
    public void initialize() throws IOException {
        filter = new MagFilter();
        view.setItems(filter.toDisplay());
        view.setCellFactory((ListView<Magasin> mag ) -> new MagCell());
        view.setFocusTraversable( false );
    }

    @FXML
    void filter(ActionEvent event) {
        filter.setFilter(field.getText());
        filter.filter();
    }
}

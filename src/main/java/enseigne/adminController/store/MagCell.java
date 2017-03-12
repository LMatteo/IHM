package enseigne.adminController.store;

import enseigne.ToNode;
import enseigne.customerController.MagControl;
import enseigne.modele.magasin.Magasin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;

import java.io.IOException;

public final class MagCell extends ListCell<Magasin>{

    @Override
    protected void updateItem(Magasin item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item== null) {
            this.setGraphic(null);
            this.setText(null);
        }
        else {
            try {
                Node listElement = ToNode.magasins(item,null);
                this.setGraphic(listElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

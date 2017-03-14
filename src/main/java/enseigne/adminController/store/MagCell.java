package enseigne.adminController.store;

import enseigne.ToNode;
import enseigne.modele.magasin.Magasin;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;

public final class MagCell extends ListCell<Magasin>{

    @Override
    protected void updateItem(Magasin item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null) {
            setGraphic(null);
            setText(null);
        }
        else {
            try {
                Node listElement = ToNode.magasins(item, null);
                this.setGraphic(listElement);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

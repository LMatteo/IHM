package enseigne.adminController.store;

import enseigne.ToNode;
import enseigne.modele.magasin.Magasin;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public final class MagCell extends ListCell<Magasin>{

    @Override
    protected void updateItem(Magasin item, boolean empty) {
        super.updateItem(item, empty);
        if(item!=null) {
            try {
                Node listElement = ToNode.magasins(item, null);
                this.setGraphic(listElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

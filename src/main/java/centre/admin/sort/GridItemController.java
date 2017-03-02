package centre.admin.sort;

import centre.CentrePath;
import centre.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.MalformedURLException;

/**
 * Controller class for an item in the grid of stores of each category in the
 * sorting order editor screen.
 */
public class GridItemController {

    @FXML private ImageView logo;
    @FXML private Label storeName;

    private Store store;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public Store getStore() {
        return store;
    }

    /**
     * Initializes this store name and logo for this item.
     *
     * @param store    - the store to load data from
     * @throws MalformedURLException - if the image was not found
     */
    public void initializeContent(Store store) throws MalformedURLException {
        this.store = store;
        logo.setImage(new Image(CentrePath.getLogoPath(store.getLogoName())));
        storeName.setText(store.getName());
        selected = false;
    }

    /**
     * Switches the state of this item between selected or not.
     *
     * @param event - the event of this action
     */
    @FXML
    void select(MouseEvent event) {
        if (selected) {
            selected = false;
            storeName.setStyle("-fx-font: 13 System;");
        } else {
            selected = true;
            storeName.setStyle("-fx-font: 13 System; -fx-background-color: #add8e6");
        }
    }

}

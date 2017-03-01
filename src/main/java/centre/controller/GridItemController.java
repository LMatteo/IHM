package centre.controller;

import centre.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

    public void initializeContent(Store store) {

    }

    @FXML
    void select(MouseEvent event) {

    }

}

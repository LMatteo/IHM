package centre.controller;

import centre.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for a store item in one category.
 */
public class CategoryItemController {

    @FXML private ImageView logo;
    @FXML private Label mapLocation;
    @FXML private Label name;
    @FXML private Label promotion;
    @FXML private Label storePage;

    /**
     * Initializes the content of the store in the appropriate fields.
     *
     * @param store - the store for this tem
     */
    public void initializeContent(Store store) {
        logo.setImage(new Image(getClass().getClassLoader().getResource("images/centre/" + store.getLogoName()).toString()));
        mapLocation.setText(store.getLocation());
        name.setText(store.getName());
        promotion.setText(store.getPromotion());
    }

    /**
     * Called when clicking on the text description of the location of the store.
     * Redirects to the info screen.
     *
     * @param event - the mouse event of the action
     */
    @FXML
    void locationClick(MouseEvent event) {

    }

    /**
     * Called when clicking on the logo image of the store.
     * Redirects to the enseigne screen.
     *
     * @param event - the mouse event of the action
     */
    @FXML
    void logoClick(MouseEvent event) {

    }

    /**
     * Called when clicking on the text to access the store screen.
     *
     * @param event - the mouse event of the action
     */
    @FXML
    void storeClick(MouseEvent event) {

    }

}

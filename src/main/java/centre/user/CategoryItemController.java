package centre.user;

import centre.constant.CentrePaths;
import centre.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.MalformedURLException;

import static centre.constant.ButtonLabels.ACCESS_EN;
import static centre.constant.ButtonLabels.ACCESS_FR;

/**
 * Controller class for a store item in one category.
 */
public class CategoryItemController implements LanguageSwitcher{

    @FXML private ImageView logo;
    @FXML private Label mapLocation;
    @FXML private Label name;
    @FXML private Label promotion;
    @FXML private Label storePage;

    private boolean french = true;
    private Store store;

    /**
     * Initializes the content of the store in the appropriate fields.
     *
     * @param store - the store for this tem
     */
    public void initializeContent(Store store) throws MalformedURLException {
        this.store = store;
        logo.setImage(new Image(CentrePaths.getLogoPath(store.getLogoName())));
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

    /**
     * Switches the language of the interface back and forth between french and english.
     */
    @Override
    public void switchLanguage() {
        if (french) {
            french = false;
            storePage.setText(ACCESS_EN);
            promotion.setText(store.getPromotionEnglish());
            mapLocation.setText(store.getLocationEnglish());
        } else {
            french = true;
            storePage.setText(ACCESS_FR);
            promotion.setText(store.getPromotion());
            mapLocation.setText(store.getLocation());
        }
    }
}

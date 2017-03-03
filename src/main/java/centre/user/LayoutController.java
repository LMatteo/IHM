package centre.user;

import centre.model.NewsList;
import centre.model.StoreList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URISyntaxException;

import static centre.constant.ButtonLabels.*;

/**
 * Controller for the main layout of the centre screen.
 */
public class LayoutController {

    private static final String normal = "#4B77BE";
    private static final String active = "#84a5c9";

    @FXML private ScrollPane pane;
    @FXML private Button actualite;
    @FXML private Button boutiques;
    @FXML private Button infopratiques;

    private Button previous;
    private AnchorPane ap;
    private StoreList loadedStores;
    private NewsList newsList;
    private boolean french = true;
    private LanguageSwitcher loadedController;

    /**
     * Starts up the interface in the news screen.
     *
     * @throws IOException        - if failing to load the fxml
     * @throws URISyntaxException - if failing to find one of the folders
     */
    @FXML
    public void initialize() throws IOException, URISyntaxException {
        loadedStores = new StoreList();
        newsList = new NewsList();
        goToActu(null);
    }

    /**
     * Switches to the news screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToActu(ActionEvent event) throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/news.fxml"));
        ap = loader.load();
        NewsController controller = loader.getController();
        controller.initializeContent(newsList);
        switchCurrentController(controller);
        pane.setContent(ap);
        switchButtonStyle(actualite);
    }

    /**
     * Switches the language of the currently loaded fxml if necessary.
     *
     * @param sw - the controller of the fxml to load
     */
    private void switchCurrentController(LanguageSwitcher sw) {
        loadedController = sw;
        if (!french) {
            loadedController.switchLanguage();
        }
    }

    /**
     * Switches the style of the top buttons so that the selected screen appears highlighted.
     *
     * @param current - the last button used
     */
    private void switchButtonStyle(Button current) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + normal + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        current.setStyle("-fx-background-color: " + active + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = current;

    }

    /**
     * Switches to the store screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException        - if failing to load the fxml
     * @throws URISyntaxException - if failing to find one of the folders
     */
    @FXML
    void goToBoutiques(ActionEvent event) throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/store.fxml"));
        ap = loader.load();
        StoreController controller = loader.getController();
        controller.initializeContent(loadedStores);
        switchCurrentController(controller);
        pane.setContent(ap);
        switchButtonStyle(boutiques);
        pane.setVvalue(0);
    }

    /**
     * Switches to the info screen.
     *
     * @param event - the mouse event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToInfoPratiques(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/info.fxml"));
        ap = loader.load();
        InfoController controller = loader.getController();
        controller.initializeContent(loadedStores);
        switchCurrentController(controller);
        pane.setContent(ap);
        switchButtonStyle(infopratiques);
        pane.setVvalue(0);
    }

    /**
     * Switches the language of the interface.
     *
     * @param event - the event of this action
     */
    @FXML
    void switchLanguage(MouseEvent event) {
        loadedController.switchLanguage();
        if (french) {
            french = false;
            actualite.setText(NEWS_EN);
            boutiques.setText(STORE_EN);
            infopratiques.setText(INFO_EN);
        } else {
            french = true;
            actualite.setText(NEWS_FR);
            boutiques.setText(STORE_FR);
            infopratiques.setText(INFO_FR);
        }
    }

}

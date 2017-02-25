package centre.controller;

import centre.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

//TODO: refactor this class with LayoutController to avoid code duplication

/**
 * Controller for the administrator main layout of the centre screen.
 */
public class AdminLayoutController {

    private static final String normal = "#4B77BE";
    private static final String active = "#84a5c9";

    @FXML private ScrollPane pane;
    @FXML private Button actualite;
    @FXML private Button boutiques;
    @FXML private Button infopratiques;

    private Button previous;
    private AnchorPane ap;
    private List<Store> loadedStores;

    /**
     * Starts up the interface in the news screen.
     *
     * @throws IOException        - if failing to load the fxml
     * @throws URISyntaxException - if failing to find one of the folders
     */
    @FXML
    public void initialize() throws IOException, URISyntaxException {
        //TODO: change this to the edit news fxml once implemented
        initStores();
        goToBoutiques(null);
    }

    /**
     * Initializes store data.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    private void initStores() throws IOException, URISyntaxException {
        File[] storeFolder = new File(getClass().getClassLoader().getResource("data/centre/stores/").toURI()).listFiles();
        if (storeFolder == null) {
            System.out.println("Could not find store data.");
            return;
        }
        loadedStores = new ArrayList<>();
        for (File file : storeFolder) {
            loadedStores.add(new Store(file));
        }
    }

    /**
     * Switches to the new editor screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToActu(ActionEvent event) throws IOException {

    }

    /**
     * Switches to the store editor screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException        - if failing to load the fxml
     * @throws URISyntaxException - if failing to find one of the folders
     */
    @FXML
    void goToBoutiques(ActionEvent event) throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/adminStore.fxml"));
        ap = loader.load();
        AdminStoreController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        pane.setContent(ap);
        switchButtonStyle(boutiques);
        pane.setVvalue(0);
    }

    /**
     * Switches to the info editor screen.
     *
     * @param event - the mouse event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToInfoPratiques(ActionEvent event) throws IOException {

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

}

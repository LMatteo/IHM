package centre.controller;

import centre.StoreList;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Controller class for the store selector screen.
 */
public class StoreSelectorController {

    @FXML
    private GridPane grid;

    private StoreList loadedStores;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Initializes the content of the gridPane. The gridPane displays a map id in each cell,
     * followed by the corresponding store if found.
     */
    public void initializeContent() {

    }


}

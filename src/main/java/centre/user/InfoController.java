package centre.user;

import centre.model.Store;
import centre.model.StoreList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Controller for the info screen.
 */
public class InfoController {

    private StoreList loadedStores;

    @FXML
    private GridPane grid;

    /**
     * Initializes the store data required to fill the map indications.
     *
     * @param loadedStores - the list of loaded stores
     */
    public void initializeContent(StoreList loadedStores) {
        this.loadedStores = loadedStores;
        initGrid();
    }

    /**
     * Initializes the map indications : displays each store map id and places it
     * in the correct location in the gridPane containing the map legend.
     */
    private void initGrid() {
        for (Store store : loadedStores.getList()) {
            int id = store.getMapId();
            Label label = new Label(Integer.toString(id + 1) + ". " + store.getName());
            label.setPrefSize(141, 54);
            label.setStyle("-fx-font: 15 System;");
            GridPane.setColumnIndex(label, id / 6);
            GridPane.setRowIndex(label, id % 6);
            grid.getChildren().add(label);
        }
    }

}


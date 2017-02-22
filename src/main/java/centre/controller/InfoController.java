package centre.controller;

import centre.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * Controller for the info screen.
 */
public class InfoController {

    private List<Store> loadedStores;

    @FXML
    private GridPane grid;

    /**
     * Initializes the store data required to fill the map indications.
     *
     * @param loadedStores - the list of loaded stores
     */
    public void initializeContent(List<Store> loadedStores) {
        this.loadedStores = loadedStores;
        initGrid();
    }

    /**
     * Initializes the map indications : displays each store map id and places it
     * in the correct location in the gridpane containing the map legend.
     */
    private void initGrid() {
        for (Store store : loadedStores) {
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


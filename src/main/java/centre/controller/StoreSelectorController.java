package centre.controller;

import centre.Store;
import centre.StoreList;
import centre.transition.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


/**
 * Controller class for the store selector screen.
 */
public class StoreSelectorController {

    @FXML private GridPane grid;
    @FXML private Button mainButton;

    private StoreList loadedStores;
    private Store selectedStore;
    private Label selectedLabel;
    private Transition transition;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Initializes the content of the gridPane. The gridPane displays a map id in each cell,
     * followed by the corresponding store if found.
     *
     * @param transition - the transition used after the store is selected
     */
    public void initializeContent(Transition transition) {
        this.transition = transition;
        for (int i = 0; i <= 17; i++) {
            Optional<Store> store = loadedStores.getStoreWithId(i);
            Label label;
            if (store.isPresent()) {
                label = new Label("   " + Integer.toString(i) + ". " + store.get().getName());
                label.setPrefSize(330, 83);
                label.setStyle("-fx-background-color: #dcdcdc; -fx-font: 20 System;");
                label.setAlignment(Pos.CENTER_LEFT);
                label.setOnMouseClicked(event -> {
                    label.setStyle("-fx-background-color: #add8e6; -fx-font: 20 System;");
                    if (selectedLabel != null && selectedLabel != label) {
                        selectedLabel.setStyle("-fx-background-color: #dcdcdc; -fx-font: 20 System;");
                    }
                    selectedLabel = label;
                    selectedStore = store.get();
                });
            } else {
                label = new Label("   " + Integer.toString(i) + ".");
                label.setStyle("-fx-font: 20 System;");
            }
            GridPane.setRowIndex(label, i % 6);
            GridPane.setColumnIndex(label, i / 6);
            grid.getChildren().add(label);
        }
    }

    /**
     * Confirm the action of the selector, and transitions to the next screen with
     * the selected store.
     *
     * @param event - the action vent of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void confirm(ActionEvent event) throws IOException {
        Stage stage = (Stage) grid.getScene().getWindow();
        stage.close();
        transition.doTransition(selectedStore, loadedStores);
    }

}

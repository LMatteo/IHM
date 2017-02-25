package centre.controller;

import centre.Store;
import centre.StoreList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private boolean deleteMode = false;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Sets up the selector to delete the selected store when confirmed.
     */
    public void setDeleteMode() {
        deleteMode = true;
        mainButton.setText("Supprimer boutique");
    }

    /**
     * Initializes the content of the gridPane. The gridPane displays a map id in each cell,
     * followed by the corresponding store if found.
     */
    public void initializeContent() {
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
     * Confirm the action of the selector : open the store editor with the selected
     * store data, or delete the selected store.
     *
     * @param event - the action vent of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void confirm(ActionEvent event) throws IOException {
        Stage stage = (Stage) grid.getScene().getWindow();
        stage.close();
        if (!deleteMode) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeForm.fxml"));
            Parent rootNode = loader.load();
            StoreFormController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.loadStoreData(selectedStore);
            Scene scene = new Scene(rootNode, 1477, 861);
            Stage newStage = new Stage();
            newStage.setTitle("Edition d'une boutique");
            newStage.setScene(scene);
            newStage.show();
        } else {
            selectedStore.delete();
            loadedStores.remove(selectedStore);
        }
    }

}

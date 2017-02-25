package centre.controller;

import centre.Store;
import centre.StoreList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


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
        for (int i = 0; i <= 17; i++) {
            Optional<Store> store = loadedStores.getStoreWithId(i);
            Label label;
            if (store.isPresent()) {
                label = new Label("   " + Integer.toString(i) + ". " + store.get().getName());
                label.setPrefSize(330, 83);
                label.setStyle("-fx-background-color: #dcdcdc; -fx-font: 20 System;");
                label.setAlignment(Pos.CENTER_LEFT);
                label.setOnMouseClicked(event -> {
                    Stage stage = (Stage) label.getScene().getWindow();
                    stage.close();
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeForm.fxml"));
                        Parent rootNode = loader.load();
                        StoreFormController controller = loader.getController();
                        controller.setLoadedStores(loadedStores);
                        controller.loadStoreData(store.get());
                        Scene scene = new Scene(rootNode, 1477, 861);
                        Stage newStage = new Stage();
                        newStage.setTitle("Edition d'une boutique");
                        newStage.setScene(scene);
                        newStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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


}

package centre.controller;


import centre.StoreList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the edit store screen.
 */
public class AdminStoreController {

    private StoreList loadedStores;

    /**
     * Sets the list of loaded stores.
     *
     * @param loadedStores - the list of stores loaded from the data folder
     */
    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Launches the store form to add a boutique.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void addStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeForm.fxml"));
        Parent rootNode = loader.load();
        StoreFormController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        Scene scene = new Scene(rootNode, 1477, 861);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

    /**
     * Opens the window to select a store, and sets it up in delete mode.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void deleteStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeSelector.fxml"));
        Parent rootNode = loader.load();
        StoreSelectorController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        controller.initializeContent();
        controller.setDeleteMode();
        Scene scene = new Scene(rootNode, 968, 555);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Supprimer une boutique");
        stage.show();
    }

    /**
     * Opens the window to select a store.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void editStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeSelector.fxml"));
        Parent rootNode = loader.load();
        StoreSelectorController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        controller.initializeContent();
        Scene scene = new Scene(rootNode, 968, 555);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sélectionner une boutique");
        stage.show();
    }

}

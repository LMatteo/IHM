package centre.controller;


import centre.StoreList;
import centre.transition.DeleteTransition;
import centre.transition.EditStoreTransition;
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
        controller.initializeContent(new DeleteTransition());
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
        controller.initializeContent(new EditStoreTransition());
        Scene scene = new Scene(rootNode, 968, 555);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sélectionner une boutique");
        stage.show();
    }

    /**
     * Opens the window to edit the sorting of the stores.
     *
     * @param event - the action event of this action
     */
    @FXML
    void editSort(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/editSort.fxml"));
        Parent rootNode = loader.load();
        EditSortController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        Scene scene = new Scene(rootNode, 1449, 951);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Editer le tri des boutiques");
        stage.show();
    }

}

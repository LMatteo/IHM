package centre.controller;


import centre.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Controller class for the edit store screen.
 */
public class AdminStoreController {

    private List<Store> loadedStores;

    /**
     * Sets the list of loaded stores.
     *
     * @param loadedStores - the list of stores loaded from the data folder
     */
    public void setLoadedStores(List<Store> loadedStores) {
        this.loadedStores = loadedStores;
    }

    @FXML
    void addStore(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/centre/storeForm.fxml"));
        Scene scene = new Scene(rootNode, 1477, 861);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

    @FXML
    void deleteStore(ActionEvent event) {

    }

    @FXML
    void editStore(ActionEvent event) {

    }

}

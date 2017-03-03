package centre.transition;

import centre.admin.store.StoreFormController;
import centre.model.Store;
import centre.model.StoreList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Transition used to pass the selected store to the edit store screen.
 *
 * @author Guillaume Andre
 */
public class EditStoreTransition implements Transition {

    /**
     * Loads the selected store data in a new store from window.
     *
     * @param selectedStore - the selected store
     * @param loadedStores  - the list of loaded stores
     * @throws IOException - if failing to load the fxml or one of the store files
     */
    @Override
    public void doTransition(Store selectedStore, StoreList loadedStores) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/store/storeForm.fxml"));
        Parent rootNode = loader.load();
        StoreFormController controller = loader.getController();
        controller.setLoadedStores(loadedStores);
        controller.loadStoreData(selectedStore);
        Scene scene = new Scene(rootNode, 1477, 861);
        Stage newStage = new Stage();
        newStage.setTitle("Edition d'une boutique");
        newStage.setScene(scene);
        newStage.show();
    }

}

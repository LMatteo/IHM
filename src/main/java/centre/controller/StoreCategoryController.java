package centre.controller;

import centre.Store;
import centre.StoreList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

/**
 * Controller for each category of a sorting order.
 */
public class StoreCategoryController {

    @FXML
    private VBox items;

    /**
     * Initializes the content of this category.
     *
     * @param stores   - the stores loaded in resources
     * @param category - the name of this category
     * @throws IOException - if failing to load the fxml
     */
    public void initializeContent(StoreList stores, String category) throws IOException {
        List<Store> matching = stores.findMatchingStores(category);
        for (Store store : matching) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/categoryItem.fxml"));
            HBox hb = loader.load();
            CategoryItemController controller = loader.getController();
            controller.initializeContent(store);
            items.getChildren().add(hb);
        }
    }

}

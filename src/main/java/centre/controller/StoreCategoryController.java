package centre.controller;

import centre.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
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
    public void initializeContent(List<Store> stores, String category) throws IOException {
        List<Store> matching = findMatchingStores(stores, category);
        for (Store store : matching) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/categoryItem.fxml"));
            HBox hb = loader.load();
            CategoryItemController controller = loader.getController();
            controller.initializeContent(store);
            items.getChildren().add(hb);
        }
    }

    /**
     * Filters a list of stores, keeping only the stores matching a given category.
     *
     * @param stores   - the list of stores to filter
     * @param category - the name of the category to filter with
     * @return a filtered list of stores according to the given category
     */
    private List<Store> findMatchingStores(List<Store> stores, String category) {
        List<Store> result = new ArrayList<>();
        for (Store store : stores) {
            if (store.matchesCategory(category)) {
                result.add(store);
            }
        }
        return result;
    }

}

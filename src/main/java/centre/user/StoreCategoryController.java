package centre.user;

import centre.model.Store;
import centre.model.StoreList;
import centre.model.Tag;
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
public class StoreCategoryController implements LanguageSwitcher {

    @FXML
    private VBox items;

    private List<LanguageSwitcher> children;
    private LayoutController layout;

    public void setLayout(LayoutController layout) {
        this.layout = layout;
    }

    /**
     * Initializes the content of this category.
     *
     * @param stores   - the stores loaded in resources
     * @param category - the name of this category
     * @throws IOException - if failing to load the fxml
     */
    public void initializeContent(StoreList stores, Tag category) throws IOException {
        children = new ArrayList<>();
        List<Store> matching = stores.findMatchingStores(category);
        for (Store store : matching) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/categoryItem.fxml"));
            HBox hb = loader.load();
            CategoryItemController controller = loader.getController();
            controller.setLayout(layout);
            controller.initializeContent(store);
            children.add(controller);
            items.getChildren().add(hb);
        }
    }

    /**
     * Switches the language of all stores in this category.
     */
    @Override
    public void switchLanguage() {
        for (LanguageSwitcher sw : children) {
            sw.switchLanguage();
        }
    }

}

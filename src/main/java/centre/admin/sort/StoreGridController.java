package centre.admin.sort;

import centre.model.Store;
import centre.model.StoreList;
import centre.model.Tag;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for a category in the sorting order editor.
 */
public class StoreGridController {

    @FXML private TitledPane categoryName;
    @FXML private GridPane grid;

    private StoreList loadedStores;
    private Tag category;
    private List<GridItemController> children;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    public Tag getCategory() {
        return category;
    }

    public TitledPane getRoot() {
        return categoryName;
    }

    /**
     * Deletes this controller tag from all the stores its grid contains.
     * Reloads the grid content to get rid of the removed stores.
     *
     * @throws IOException - if failing to reload the stores
     */
    public void deleteSelectedStoresTags() throws IOException {
        for (GridItemController controller : children) {
            if (controller.isSelected()) {
                controller.getStore().removeCategory(category);
            }
        }
        initializeContent(category);
    }

    /**
     * Fills the grid with the data of the stores matching the category.
     *
     * @param category - the category of this controller
     * @throws IOException - if failing to load the fxml
     */
    public void initializeContent(Tag category) throws IOException {
        grid.getChildren().clear();
        children = new ArrayList<>();
        this.category = category;
        categoryName.setText(category.getFrench() + " = " + category.getEnglish());
        List<Store> matches = loadedStores.findMatchingStores(category);
        for (Store store : matches) {
            addItem(store);
        }
    }

    /**
     * Adds a store to this category, and displays it in the grid.
     *
     * @param store - the store to add to the category
     * @throws IOException -
     */
    public void addItem(Store store) throws IOException {
        if (!isAlreadyInGrid(store)) {
            store.addCategory(category);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/gridItem.fxml"));
            VBox item = loader.load();
            GridItemController controller = loader.getController();
            controller.initializeContent(store);
            children.add(controller);
            GridPane.setColumnIndex(item, grid.getChildren().size() % 6);
            GridPane.setRowIndex(item, grid.getChildren().size() / 6);
            grid.getChildren().add(item);
        }
    }

    /**
     * Checks whether a store is already in this category or not.
     *
     * @param store - the store to check
     * @return true if the store is already in the grid, false otherwise
     */
    public boolean isAlreadyInGrid(Store store) {
        for (GridItemController controller : children) {
            if (controller.getStore().equals(store)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates this tag name. Also replaces the old tag by the new tag in all the stores
     * matching the old category.
     *
     * @param newTag - the new tag
     */
    public void updateTag(Tag newTag) {
        categoryName.setText(newTag.getFrench() + " = " + newTag.getEnglish());
        for (GridItemController controller : children) {
            Store store = controller.getStore();
            store.removeCategory(category);
            store.addCategory(newTag);
        }
        category = newTag;
    }

}

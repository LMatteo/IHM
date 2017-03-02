package centre.controller;

import centre.Store;
import centre.StoreList;
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
    private List<GridItemController> gridItems;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Fills the grid with the data of the stores matching the category.
     *
     * @param category - the category of this controller
     * @throws IOException - if failing to load the fxml
     */
    public void initializeContent(String category) throws IOException {
        categoryName.setText(category);
        List<Store> matches = loadedStores.findMatchingStores(category);
        gridItems = new ArrayList<>();
        for (int i = 0; i < matches.size(); i++) {
            Store store = matches.get(i);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/gridItem.fxml"));
            VBox item = loader.load();
            GridItemController controller = loader.getController();
            controller.initializeContent(store, category);
            gridItems.add(controller);
            GridPane.setColumnIndex(item, i % 6);
            GridPane.setRowIndex(item, i / 6);
            grid.getChildren().add(item);
        }
    }

}

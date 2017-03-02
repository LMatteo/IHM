package centre.user;

import centre.admin.store.CategoryItemController;
import centre.model.SortOrder;
import centre.model.Store;
import centre.model.StoreList;
import centre.model.Tag;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class StoreController {

    private StoreList loadedStores;
    private List<SortOrder> sortOrders;

    @FXML private TextArea searchBar;
    @FXML private VBox search;
    @FXML private VBox accBox;
    @FXML private Button searchButton;
    @FXML private MenuButton sortMenu;
    @FXML private Accordion accordion;

    /**
     * Loads store data and sorting order from the data folder.
     * Loads the first sorting order found by default.
     *
     * @param loadedStores - the list of stores loaded from the data folder
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    public void initializeContent(StoreList loadedStores) throws IOException, URISyntaxException {
        this.loadedStores = loadedStores;
        initSort();
        createMenuItems();
        if (!sortOrders.isEmpty()) {
            loadCategories(sortOrders.get(0));
        }
    }


    /**
     * Initializes sorting order data.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    private void initSort() throws IOException, URISyntaxException {
        File[] sortFolder = new File("data/centre/sort/").listFiles();
        if (sortFolder == null) {
            exit("Could not find sorting data.");
            return;
        }
        sortOrders = new ArrayList<>();
        for (File file : sortFolder) {
            sortOrders.add(new SortOrder(file));
        }
    }

    /**
     * Fills the menuButton "Trier par..." with the loaded sorting orders.
     */
    private void createMenuItems() {
        for (SortOrder order : sortOrders) {
            MenuItem item = new MenuItem(order.getName());
            item.setOnAction(event -> {
                clearSearchResult();
                sortMenu.setText(order.getName());
                SortOrder so = getOrder(order.getName());
                if (so != null) {
                    try {
                        loadCategories(so);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            sortMenu.getItems().add(item);
        }
    }

    /**
     * Loads the categories of the requested sorting order.
     *
     * @param order - the sorting order to load
     * @throws IOException - if failing to find the fxml
     */
    private void loadCategories(SortOrder order) throws IOException {
        accordion.getPanes().clear();
        for (Tag category : order.getCategories()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/storeCategory.fxml"));
            TitledPane tl = loader.load();
            tl.setText(category.getFrench());
            StoreCategoryController controller = loader.getController();
            controller.initializeContent(loadedStores, category);
            accordion.getPanes().add(tl);
        }
    }

    /**
     * Displays an error message.
     *
     * @param message - message to display before quitting
     */
    private void exit(String message) {
        System.out.println(message);
    }

    /**
     * Clears all search results from the store screen.
     */
    private void clearSearchResult() {
        for (int i = accBox.getChildren().size() - 1; i > 1; i--) {
            accBox.getChildren().remove(i);
        }
    }

    /**
     * Returns the sorting order with the requested name, or null if not found.
     *
     * @param name - the name of the sorting order to search
     * @return the sorting order of the requested name if found, null otherwise
     */
    private SortOrder getOrder(String name) {
        for (SortOrder so : sortOrders) {
            if (name.equals(so.getName())) {
                return so;
            }
        }
        return null;
    }

    /**
     * Updates the search suggestions according to what was typed in the search bar.
     *
     * @param event - the key event of the pressed key
     * @throws IOException - if failing to find the fxml for a suggestion item
     */
    @FXML
    void searchType(KeyEvent event) throws IOException {
        if (searchBar.getText().equals("")) {
            clearSearchSuggestions();
            clearSearchResult();
            loadCategories(sortOrders.get(0));
            return;
        }
        confirmSearch(null);
        if (event.getCode() == KeyCode.ENTER) {
            searchBar.setText(searchBar.getText().substring(0, searchBar.getText().length() - 1));
            confirmSearch(null);
        }
        List<Store> matches = loadedStores.getStoreStartingWith(searchBar.getText());
        clearSearchSuggestions();
        for (Store match : matches) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/user/searchItem.fxml"));
            AnchorPane hb = loader.load();
            SearchItemController sic = loader.getController();
            sic.initializeContent(match.getName(), searchBar);
            search.getChildren().add(hb);
        }
    }

    /**
     * Clears all search suggestions for the search bar.
     */
    private void clearSearchSuggestions() {
        ObservableList<Node> children = search.getChildren();
        for (int i = children.size() - 1; i > 0; i--) {
            children.remove(i);
        }
    }

    /**
     * Displays all stores whose name starts with the requested search.
     * Called when the search button is used.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the store item fxml
     */
    @FXML
    void confirmSearch(ActionEvent event) throws IOException {
        accordion.getPanes().clear();
        clearSearchResult();
        for (Store match : loadedStores.getStoreStartingWith(searchBar.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/store/categoryItem.fxml"));
            HBox hb = loader.load();
            CategoryItemController controller = loader.getController();
            controller.initializeContent(match);
            accBox.getChildren().add(hb);
        }
    }


}

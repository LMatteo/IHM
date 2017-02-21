package centre.controller;

import centre.SortOrder;
import centre.Store;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class StoreController {

    private final static int MAX_SUGGESTIONS = 5;

    private List<Store> loadedStores;
    private List<SortOrder> sortOrders;

    @FXML
    private TextArea searchBar;

    @FXML
    private VBox search;

    @FXML
    private Button searchButton;

    @FXML
    private MenuButton sortMenu;

    @FXML
    private Accordion accordion;

    /**
     * Loads store data and sorting order from the data folder.
     * Loads the first sorting order found by default.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    @FXML
    public void initialize() throws IOException, URISyntaxException {
        initStores();
        initSort();
        createMenuItems();
        if (!sortOrders.isEmpty()) {
            loadCategories(sortOrders.get(0));
        }
    }

    /**
     * Initializes store data.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    private void initStores() throws IOException, URISyntaxException {
        File[] storeFolder = new File(getClass().getClassLoader().getResource("data/centre/stores/").toURI()).listFiles();
        if (storeFolder == null) {
            exit("Could not find store data.");
            return;
        }
        loadedStores = new ArrayList<>();
        for (File file : storeFolder) {
            loadedStores.add(new Store(file));
        }
    }

    /**
     * Initializes sorting order data.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    private void initSort() throws IOException, URISyntaxException {
        File[] sortFolder = new File(getClass().getClassLoader().getResource("data/centre/sort/").toURI()).listFiles();
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
     * Loads the categories of the requested sorting order.
     *
     * @param order - the sorting order to load
     * @throws IOException - if failing to find the fxml
     */
    private void loadCategories(SortOrder order) throws IOException {
        accordion.getPanes().clear();
        for (String category : order.getCategories()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeCategory.fxml"));
            TitledPane tl = loader.load();
            tl.setText(category);
            StoreCategoryController controller = loader.getController();
            controller.initializeContent(loadedStores, category);
            accordion.getPanes().add(tl);
        }
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
            return;
        }
        List<String> matches = getStoreStartingWith(searchBar.getText());
        ObservableList<Node> children = search.getChildren();
        for (int i = children.size() - 1; i > 0; i--) {
            children.remove(i);
        }
        for (String match : matches) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/searchItem.fxml"));
            AnchorPane ap = loader.load();
            SearchItemController sic = loader.getController();
            sic.initializeContent(match);
            search.getChildren().add(ap);
        }
    }

    /**
     * Returns all stores whose name starts with the requested prefix.
     *
     * @param prefix - the prefix to filter stores with
     * @return a list of all loaded store whose name start with the specified prefix
     */
    private List<String> getStoreStartingWith(String prefix) {
        List<String> result = new ArrayList<>();
        for (Store store : loadedStores) {
            if (store.getName().startsWith(prefix)) {
                result.add(store.getName());
            }
            if (result.size() == MAX_SUGGESTIONS) {
                break;
            }
        }
        return result;
    }

    /**
     * Displays an error message.
     *
     * @param message - message to display before quitting
     */
    private void exit(String message) {
        System.out.println(message);
    }


}

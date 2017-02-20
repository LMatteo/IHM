package centre.controller;

import centre.SortOrder;
import centre.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class StoreController {

    private List<Store> loadedStores;
    private List<SortOrder> sortOrders;

    @FXML
    private TextArea searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private MenuButton sortMenu;

    @FXML
    private Accordion accordion;

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        initStores();
        initSort();
        createMenuItems();
        if (!sortOrders.isEmpty()) {
            loadCategories(sortOrders.get(0));
        }
    }

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

    private SortOrder getOrder(String name) {
        for (SortOrder so : sortOrders) {
            if (name.equals(so.getName())) {
                return so;
            }
        }
        return null;
    }

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

    private void exit(String message) {
        System.out.println(message);
    }


}

package centre.controller;

import centre.SortOrder;
import centre.StoreList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the store editor screen.
 */
public class EditSortController {

    @FXML private TextField newCategory;
    @FXML private Label sortName;
    @FXML private Accordion accordion;

    private StoreList loadedStores;
    private SortOrder loadedOrder;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Initializes the empty sorting order name.
     */
    @FXML
    public void initialize() {
        sortName.setText("Aucun mode de tri chargé");
        sortName.setTextFill(Paint.valueOf("#ff0000"));
    }

    /**
     * Loads a sorting order in the editor.
     *
     * @param order - the sorting order to load
     * @throws IOException - if failing ot load the fxml
     */
    public void load(SortOrder order) throws IOException {
        loadedOrder = order;
        sortName.setText(order.getName());
        sortName.setTextFill(Paint.valueOf("#000000"));
        for (String category : order.getCategories()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeGrid.fxml"));
            TitledPane root = loader.load();
            StoreGridController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.initializeContent(category);
            accordion.getPanes().add(root);
        }
    }

    /**
     * Adds a new category to the sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void addCategory(ActionEvent event) throws IOException {
        if (!newCategory.getText().equals("")) {
            loadedOrder.addCategory(newCategory.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/storeGrid.fxml"));
            TitledPane root = loader.load();
            StoreGridController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.initializeContent(newCategory.getText());
            accordion.getPanes().add(root);
            newCategory.setText("");
        }
    }

    @FXML
    void addStores(ActionEvent event) {

    }

    /**
     * Opens the window to create a new sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void createSort(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/sortTitle.fxml"));
        Parent rootNode = loader.load();
        SortTitleController controller = loader.getController();
        controller.bindTo(this);
        Scene scene = new Scene(rootNode, 559, 263);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir un nom pour le tri");
        stage.show();
    }

    @FXML
    void deleteCategory(ActionEvent event) {

    }

    @FXML
    void deleteSort(ActionEvent event) {

    }

    @FXML
    void deleteStores(ActionEvent event) {

    }

    @FXML
    void editCategory(ActionEvent event) {

    }

    /**
     * Opens up the window to load a sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void loadSort(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/sortSelector.fxml"));
        Parent rootNode = loader.load();
        SortSelectorController controller = loader.getController();
        controller.bindTo(this);
        Scene scene = new Scene(rootNode, 644, 568);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir un mode de tri");
        stage.show();
    }

    @FXML
    void confirmChanges(ActionEvent event) {

    }

}

package centre.admin.sort;

import centre.admin.store.StoreSelectorController;
import centre.model.SortOrder;
import centre.model.Store;
import centre.model.StoreList;
import centre.model.Tag;
import centre.transition.EditSortTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for the store editor screen.
 */
public class EditSortController {

    @FXML private TextField newCategory;
    @FXML private TextField newCategoryEnglish;
    @FXML private Label sortName;
    @FXML private Accordion accordion;

    private StoreList loadedStores;
    private SortOrder loadedOrder;
    private List<StoreGridController> children;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Opens the window to create a new sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void createSort(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/sortTitle.fxml"));
        Parent rootNode = loader.load();
        SortTitleController controller = loader.getController();
        controller.bindTo(this);
        Scene scene = new Scene(rootNode, 559, 345);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir un nom pour le tri");
        stage.show();
    }


    //------------------------------------------------------
    // Sorting order buttons : create, load, delete current
    //------------------------------------------------------

    /**
     * Opens the window to load a sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void loadSort(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/sortSelector.fxml"));
        Parent rootNode = loader.load();
        SortSelectorController controller = loader.getController();
        controller.bindTo(this);
        Scene scene = new Scene(rootNode, 644, 568);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Choisir un mode de tri");
        stage.show();
    }

    /**
     * Loads a sorting order in the editor. Also reloads the store data to lose any
     * unsaved changes on the currently loaded sorting order.
     *
     * @param order - the sorting order to load
     * @throws IOException        - if failing to load the fxml or reload the store data
     * @throws URISyntaxException - if failing to load the store logos
     */
    public void load(SortOrder order) throws IOException, URISyntaxException {
        if (loadedOrder != null) {
            loadedStores = new StoreList();
        }
        children = new ArrayList<>();
        loadedOrder = order;
        sortName.setText(order.getName());
        sortName.setTextFill(Paint.valueOf("#000000"));
        for (Tag category : order.getCategories()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/storeGrid.fxml"));
            TitledPane root = loader.load();
            StoreGridController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.initializeContent(category);
            children.add(controller);
            accordion.getPanes().add(root);
        }
    }

    /**
     * Deletes the loaded sorting order. Also deletes the tags related to the sorting order
     * on each individual store.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to delete the files
     */
    @FXML
    void deleteSort(ActionEvent event) throws IOException {
        if (loadedOrder != null) {
            loadedOrder.delete();
            accordion.getPanes().clear();
            initialize();
            for (Store store : loadedStores.getList()) {
                for (StoreGridController controller : children) {
                    store.removeCategory(controller.getCategory());
                }
                store.save();
            }
        }
    }

    /**
     * Initializes the empty sorting order name.
     */
    @FXML
    public void initialize() {
        sortName.setText("Aucun mode de tri chargé");
        sortName.setTextFill(Paint.valueOf("#ff0000"));
    }


    //------------------------------------------------------
    // Category buttons : add, edit, remove
    //------------------------------------------------------

    /**
     * Adds a new category to the sorting order.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void addCategory(ActionEvent event) throws IOException {
        if (!newCategory.getText().equals("") && !newCategoryEnglish.getText().equals("") && !isAlreadyPresent(newCategory.getText())) {
            Tag tag = new Tag(newCategory.getText(), newCategoryEnglish.getText());
            loadedOrder.addCategory(tag);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/storeGrid.fxml"));
            TitledPane root = loader.load();
            StoreGridController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.initializeContent(tag);
            children.add(controller);
            accordion.getPanes().add(root);
            newCategory.setText("");
            newCategoryEnglish.setText("");
        }
    }

    /**
     * Checks if a category is already present int the editor or not.
     *
     * @param category - the category to check
     * @return true if already present in the editor, false otherwise
     */
    private boolean isAlreadyPresent(String category) {
        for (TitledPane node : accordion.getPanes()) {
            String french = node.getText().substring(0, node.getText().indexOf('=')).trim();
            if (category.equals(french)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Opens the edit category window, and binds it to this controller.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void editCategory(ActionEvent event) throws IOException {
        if (loadedOrder != null) {
            Optional<StoreGridController> tagController = getExpandedController();
            if (tagController.isPresent()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/sort/tagNameEdit.fxml"));
                VBox root = loader.load();
                TagNameEditController controller = loader.getController();
                controller.bindTo(this);
                controller.initializeContent(tagController.get().getCategory());
                Scene scene = new Scene(root, 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Edition d'une catégorie");
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    /**
     * Returns an optional of the controller of the currently expanded pane of the accordion.
     * Returns an empty optional if no pane is currently expanded.
     *
     * @return an optional of the controller of the accordion expanded pane, or an empty optional if
     * no pane is currently expanded
     */
    private Optional<StoreGridController> getExpandedController() {
        for (StoreGridController controller : children) {
            if (accordion.getExpandedPane().equals(controller.getRoot())) {
                return Optional.of(controller);
            }
        }
        return Optional.empty();
    }

    /**
     * Updates the current tag with the new tag name.
     *
     * @param newTag - the new tag name
     */
    public void updateCurrentTag(Tag newTag) {
        Optional<StoreGridController> controller = getExpandedController();
        if (controller.isPresent()) {
            loadedOrder.removeCategory(controller.get().getCategory());
            loadedOrder.addCategory(newTag);
            controller.get().updateTag(newTag);
        }
    }

    /**
     * Removes a category from the sorting order.
     *
     * @param event - the event of this action
     */
    @FXML
    void deleteCategory(ActionEvent event) {
        if (loadedOrder != null) {
            Optional<StoreGridController> controller = getExpandedController();
            if (controller.isPresent()) {
                loadedOrder.removeCategory(controller.get().getCategory());
                accordion.getPanes().remove(accordion.getExpandedPane());
            }
        }
    }


    //------------------------------------------------------
    // Store buttons : add, remove selected
    //------------------------------------------------------


    /**
     * Opens up a new store selector to select the store to add to the current category.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to load the selector fxml
     */
    @FXML
    void addStores(ActionEvent event) throws IOException {
        if (loadedOrder != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/centre/admin/store/storeSelector.fxml"));
            VBox selector = loader.load();
            StoreSelectorController controller = loader.getController();
            controller.setLoadedStores(loadedStores);
            controller.initializeContent(new EditSortTransition(this));
            Scene scene = new Scene(selector, 968, 555);
            Stage stage = new Stage();
            stage.setTitle("Sélectionneer une boutique");
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Adds a store to the current category.
     *
     * @param store - the store to add
     * @throws IOException - if failing to load the fxml in the grid
     */
    public void loadNewStore(Store store) throws IOException {
        Optional<StoreGridController> controller = getExpandedController();
        if (controller.isPresent()) {
            controller.get().addItem(store);
        }
    }


    /**
     * Deletes the selected stores categories.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to reload the content after deletion
     */
    @FXML
    void deleteStores(ActionEvent event) throws IOException {
        if (loadedOrder != null) {
            for (StoreGridController controller : children) {
                controller.deleteSelectedStoresTags();
            }
        }
    }


    //------------------------------------------------------
    // Confirmation
    //------------------------------------------------------


    /**
     * Confirms the changes done on the sorting order and the stores.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to save the new changes to the data folder
     */
    @FXML
    void confirmChanges(ActionEvent event) throws IOException {
        if (loadedOrder != null) {
            loadedOrder.save();
            for (Store store : loadedStores.getList()) {
                store.save();
            }
            Stage stage = (Stage) accordion.getScene().getWindow();
            stage.close();
        }
    }

}

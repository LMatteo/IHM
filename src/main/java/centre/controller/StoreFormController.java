package centre.controller;

import centre.Store;
import centre.StoreList;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the store form.
 */
public class StoreFormController {

    @FXML private Label titleLabel;
    @FXML private VBox nameBox;
    @FXML private TextField name;
    @FXML private VBox areaBox;
    @FXML private TextField area;
    @FXML private TextField areaEnglish;
    @FXML private TextArea promoFrench;
    @FXML private TextArea promoEnglish;
    @FXML private VBox logoBox;
    @FXML private ImageView logoPreview;
    @FXML private HBox idMapBox;
    @FXML private TextField idMap;
    @FXML private HBox idEnseigneBox;
    @FXML private TextField idEnseigne;
    @FXML private HBox idMagasinBox;
    @FXML private TextField idMagasin;
    @FXML private TextField newTag;
    @FXML private VBox tagBox;

    private Label selectedTag;
    private File image;
    private File oldPic;
    private StoreList loadedStores;
    private Store edit;

    public void setLoadedStores(StoreList loadedStores) {
        this.loadedStores = loadedStores;
    }

    /**
     * Loads all fields with a store data. On confirmation, the store old data will be deleted, and the new data will be created.
     *
     * @param store - the store to load data from
     */
    public void loadStoreData(Store store) throws MalformedURLException {
        edit = store;
        titleLabel.setText("Edition d'une boutique");
        name.setText(store.getName());
        area.setText(store.getLocation());
        areaEnglish.setText(store.getLocationEnglish());
        promoEnglish.setText(store.getPromotionEnglish());
        promoFrench.setText(store.getPromotion());
        logoPreview.setImage(new Image(new File("data/centre/images/" + store.getLogoName()).toURI().toURL().toString()));
        //TODO: replace this with the working directory somehow
        image = new File("data/centre/images" + store.getLogoName());
        oldPic = image;
        idMap.setText(Integer.toString(store.getMapId()));
        idEnseigne.setText(store.getEnseigneId());
        idMagasin.setText(store.getMagasinId());
        for (String tag : store.getCategories()) {
            addTagWithText(tag);
        }
    }

    /**
     * Adds a tag to the list of tags of this store.
     *
     * @param event - the event of this action
     */
    @FXML
    void addTag(ActionEvent event) {
        if (newTag.getText().equals("") || isTag(newTag.getText())) {
            return;
        }
        addTagWithText(newTag.getText());
    }

    /**
     * Adds a tag to the list of tags with the specified text inside the label.
     *
     * @param text - the text inside the label
     */
    private void addTagWithText(String text) {
        Label tag = new Label(text);
        if (tagBox.getChildren().size() % 2 != 0) {
            tag.setStyle("-fx-font: 17 System; -fx-background-color: #dcdcdc");
        } else {
            tag.setStyle("-fx-font: 17 System;");
        }
        tag.setAlignment(Pos.CENTER);
        tag.setPrefSize(357, 35);
        tag.setOnMouseClicked(eventTag -> {
            if (tag != selectedTag) {
                if (selectedTag != null) {
                    if (tagBox.getChildren().indexOf(selectedTag) % 2 != 0) {
                        selectedTag.setStyle("-fx-font: 17 System; -fx-background-color: #dcdcdc");
                    } else {
                        selectedTag.setStyle("-fx-font: 17 System;");
                    }
                }
                selectedTag = tag;
                tag.setStyle("-fx-font: 17 System; -fx-background-color: #add8e6");
            }
        });
        tagBox.getChildren().add(tag);
        newTag.setText("");
    }

    /**
     * Checks if a given String is already defined as a Tag for this store.
     *
     * @param search - the String to check
     * @return true if already a tag, false otherwise
     */
    private boolean isTag(String search) {
        for (Node node : tagBox.getChildren()) {
            if (((Label) node).getText().equals(search)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes the selected tag from the list of tags of this store.
     *
     * @param event - the event of this action
     */
    @FXML
    void deleteTag(ActionEvent event) {
        tagBox.getChildren().remove(selectedTag);
    }

    /**
     * Opens a window to choose a picture for the new store logo.
     * Once chosen, the picture is shown in the preview ImageView.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to retrieve the picture once selected
     */
    @FXML
    void browsePic(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir l'image du logo de la boutique");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg"));
        image = chooser.showOpenDialog(new Stage());
        if (image != null) {
            BufferedImage im = ImageIO.read(image);
            logoPreview.setImage(SwingFXUtils.toFXImage(im, null));
        }
    }

    /**
     * Adds a new store and saves it with the others if all the required fields are valid.
     * If the store was successfully saved, closes the window.
     * Otherwise, displays an appropriate message.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to write the store file or copying the store logo
     */
    @FXML
    void confirm(ActionEvent event) throws IOException, URISyntaxException {
        if (edit != null) {
            loadedStores.remove(edit);
        }
        if (checkName() && checkLocation() && checkLogo() && checkMapId()) {
            Store store = new Store(name.getText(), name.getText() + getImageExtension(),
                    idEnseigne.getText(), idMagasin.getText(), getTagList(), area.getText(), areaEnglish.getText(),
                    promoFrench.getText(), promoEnglish.getText(), Integer.parseInt(idMap.getText()));
            File newPic = new File("data/centre/images/" + name.getText() + getImageExtension());
            if (edit != null && oldPic != image) {
                Files.delete(oldPic.toPath());
            }
            if (oldPic != image) {
                newPic.createNewFile();
                Files.copy(image.toPath(), newPic.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            store.save();
            loadedStores.add(store);
            //TODO: proper "successfully added or edited" window
            Stage stage = (Stage) name.getScene().getWindow();
            stage.close();
        } else {
            loadedStores.add(edit);
        }
    }

    /**
     * Checks if the name entered in the form is valid or not.
     * A name is valid if not null and under 40 characters long.
     * Shows an appropriate message if the name was not valid.
     *
     * @return true if the name is valid, false otherwise
     */
    private boolean checkName() {
        if (name.getText().equals("")) {
            addErrorLabel(nameBox.getChildren(), "Nom nécéssaire", 2);
            return false;
        }
        if (loadedStores.isTaken(name.getText())) {
            addErrorLabel(nameBox.getChildren(), "Nom déja utilisé", 2);
            return false;
        }
        if (name.getText().length() > 40) {
            addErrorLabel(nameBox.getChildren(), "40 caractères maximum", 2);
            return false;
        }
        clearErrorMessages(nameBox.getChildren(), 2);
        return true;
    }

    /**
     * Checks if the area entered in the form is valid.
     * An area is considered valid if not null.
     * Shows an appropriate message if the area was not valid.
     *
     * @return true if the area is valid, false otherwise
     */
    private boolean checkLocation() {
        if (area.getText().equals("") || areaEnglish.getText().equals("")) {
            addErrorLabel(areaBox.getChildren(), "Locations nécéssaires", 2);
            return false;
        }
        clearErrorMessages(areaBox.getChildren(), 2);
        return true;
    }

    /**
     * Checks if the provided logo for the store is valid or not.
     * Shows an appropriate message if the logo was not found.
     *
     * @return true if the logo is not null, false otherwise
     */
    private boolean checkLogo() {
        if (image == null) {
            addErrorLabel(logoBox.getChildren(), "Logo nécéssaire", 2);
            return false;
        }
        clearErrorMessages(logoBox.getChildren(), 2);
        return true;
    }

    /**
     * Checks if the provided map id is valid or not.
     * The map id is valid if not null, not taken by another store, and is a number
     * between 0 and 17 (maximum amount of stores in the centre).
     * Shows an appropriate message if invalid.
     *
     * @return true if the id is a number not taken by another store between 0 and 17, false otherwise
     */
    private boolean checkMapId() {
        if (idMap.getText().equals("")) {
            addErrorLabel(idMapBox.getChildren(), "Id map nécéssaire", 1);
            return false;
        }
        try {
            int id = Integer.parseInt(idMap.getText());
            if (loadedStores.isIdTaken(id)) {
                addErrorLabel(idMapBox.getChildren(), "Id map utilisé", 1);
                return false;
            }
            if (id < 0 || id > 17) {
                addErrorLabel(idMapBox.getChildren(), "Id entre 0 et 17", 1);
                return false;
            }
        } catch (NumberFormatException e) {
            addErrorLabel(idMapBox.getChildren(), "Nombre entre 0 et 17", 1);
            return false;
        }
        clearErrorMessages(idMapBox.getChildren(), 1);
        return true;
    }

    /**
     * Returns a list of all the tags entered.
     *
     * @return a list of all provided tags
     */
    private List<String> getTagList() {
        List<String> tags = new ArrayList<>();
        for (Node node : tagBox.getChildren()) {
            tags.add(((Label) node).getText());
        }
        return tags;
    }

    /**
     * Adds an error label with the specified message to the specified Node list.
     *
     * @param box        - the node list to place the label into
     * @param message    - the message displayed in the label
     * @param normalSize - the normal size of the list, when no extra messages are displayed
     */
    private void addErrorLabel(ObservableList<Node> box, String message, int normalSize) {
        clearErrorMessages(box, normalSize);
        Label error = new Label(message);
        error.setAlignment(Pos.CENTER);
        error.setStyle("-fx-font: 16 System;");
        error.setTextFill(Paint.valueOf("#ff0000"));
        box.add(error);
    }

    /**
     * Clears the error messages from the specified node list.
     *
     * @param box        - the node list to clean
     * @param normalSize - the normal size of the node list without error messages
     */
    private void clearErrorMessages(ObservableList<Node> box, int normalSize) {
        for (int i = normalSize; i < box.size(); i++) {
            box.remove(i);
        }
    }

    /**
     * Returns the extension (.jpg or .png) of the logo picture.
     *
     * @return the extension of the logo picture
     */
    private String getImageExtension() {
        return image.getName().substring(image.getName().lastIndexOf("."));
    }

}

package centre.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Controller class for the store form.
 */
public class StoreFormController {

    @FXML private VBox nameBox;
    @FXML private TextField name;
    @FXML private VBox areaBox;
    @FXML private TextField area;
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

    /**
     * Adds a tag to the list of tags of this store.
     *
     * @param event - the event of this action
     */
    @FXML
    void addTag(ActionEvent event) {
        if (newTag.getText().equals("")) {
            return;
        }
        Label tag = new Label(newTag.getText());
        if (tagBox.getChildren().size() % 2 != 0) {
            tag.setStyle("-fx-font: 17 System; -fx-background-color: #dcdcdc");
        } else {
            tag.setStyle("-fx-font: 17 System;");
        }
        tag.setAlignment(Pos.CENTER);
        tag.setPrefSize(357, 35);
        tag.setOnMouseClicked(eventTag -> {
            selectedTag = tag;
            tag.setStyle(tag.getStyle() + "-fx-background-color: #add8e6");
        });
        tagBox.getChildren().add(tag);
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

    @FXML
    void confirm(ActionEvent event) {

    }

}

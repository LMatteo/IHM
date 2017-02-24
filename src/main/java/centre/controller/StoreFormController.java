package centre.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    @FXML private Button browseButton;
    @FXML private ImageView logoPreview;
    @FXML private HBox idMapBox;
    @FXML private TextField idMap;
    @FXML private HBox idEnseigneBox;
    @FXML private TextField idEnseigne;
    @FXML private HBox idMagasinBox;
    @FXML private TextField idMagasin;
    @FXML private TextField newTag;
    @FXML private VBox tagBox;

    @FXML
    void addTag(ActionEvent event) {

    }

    @FXML
    void deleteTag(ActionEvent event) {

    }

    @FXML
    void confirm(ActionEvent event) {

    }

}

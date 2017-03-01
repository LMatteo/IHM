package enseigne;

import enseigne.component.Photo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class imageFormController {

    @FXML
    private TextField title;

    @FXML
    private ChoiceBox<?> category;

    @FXML
    private Button browsePhoto;

    @FXML
    private ImageView logoPreview;

    @FXML
    private TextArea descriptionFr;

    @FXML
    private TextArea decriptionEn;

    @FXML
    private Button ajoutImage;

    @FXML
    void browsePic(ActionEvent event) {
        //toudou quand on sait que ca marche pour magasinFormController
    }

    @FXML
    void ajoutMagasin(ActionEvent event) {
        Photo i = new Photo();
        String c = category.getSelectionModel().toString();
        i.setCategory(c);
        //i.setPhoto();
        i.setDescriptionEn(decriptionEn.getPromptText());
        i.setDescriptionFr(descriptionFr.getPromptText());
        i.setTitle(title.getPromptText());
        i.write();
    }


}

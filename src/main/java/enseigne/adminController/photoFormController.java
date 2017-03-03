package enseigne.adminController;

import enseigne.modele.photo.Photo;
import enseigne.modele.ReadConst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class photoFormController {

    @FXML
    private TextField titreFr;

    @FXML
    private TextField titreEn;

    @FXML
    private ChoiceBox<?> category;
    //http://stackoverflow.com/questions/35260061/combobox-items-via-scene-builder

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

    private String imagePath;

    @FXML
    void browsePic(ActionEvent event) throws FileNotFoundException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Photo Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            logoPreview.setImage(image);
            File out = new File(ReadConst.imagePath+"/"+file.getName());
            try {
                FileUtils.copyFile(file,out);
                imagePath = out.getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void ajoutMagasin(ActionEvent event) throws IOException {
        Photo i = new Photo();
        String c = category.getSelectionModel().toString();
        i.setCategory(c);
        i.setPhoto(imagePath);
        i.setDescriptionEn(decriptionEn.getPromptText());
        i.setDescriptionFr(descriptionFr.getPromptText());
        i.setTitreFr(titreFr.getPromptText());
        i.setTitreEn(titreEn.getPromptText());
        i.write();
    }


}

package enseigne;

/**
 * Created by Josué on 01/03/2017.
 */

import enseigne.component.ReadConst;
import enseigne.component.actu.Actu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class actuFormController {

    @FXML
    private TextField titreFr;

    @FXML
    private TextField titreEn;

    @FXML
    private Button browsePhoto;

    @FXML
    private ImageView logoPreview;

    @FXML
    private TextArea contentFr;

    @FXML
    private TextArea contentEn;

    @FXML
    private Button ajoutMagasin;

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
    void ajoutMagasin(ActionEvent event) {
        Actu a = new Actu();
        a.setContentEn(contentEn.getPromptText());
        a.setContentFr(contentFr.getPromptText());
        a.setTitreEn(titreEn.getPromptText());
        a.setTitreFr(titreFr.getPromptText());
        a.setImage(imagePath);

    }

}


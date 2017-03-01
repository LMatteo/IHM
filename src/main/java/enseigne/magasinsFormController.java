package enseigne;

import enseigne.component.Magasin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;

public class magasinsFormController {

    @FXML
    private TextField centreCommercial;

    @FXML
    private TextField adresse;

    @FXML
    private TextField ville;

    @FXML
    private TextField codePostal;

    @FXML
    private Button browsePhoto;

    @FXML
    private ImageView logoPreview;

    @FXML
    private TextArea informationsFr;

    @FXML
    private TextArea informationsEN;

    @FXML
    private TextField telephone;

    @FXML
    private TextField web;

    @FXML
    private Button ajoutMagasin;

    @FXML
    void browsePic(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            logoPreview.setImage(Image.impl_fromPlatformImage(file));

        }

    }

    @FXML
    void ajoutMagasin(ActionEvent event) {
        Magasin m = new Magasin();
        m.setAddr(adresse.getPromptText());
        m.setCentre(centreCommercial.getPromptText());
        m.setInfoFr(informationsFr.getPromptText());
        m.setInfoEn(informationsEN.getPromptText());
        m.setWeb(web.getPromptText());
        m.setTelephone(telephone.getPromptText());
        m.setVille(ville.getPromptText());
        m.setCodePostal(codePostal.getPromptText());
        m.write();
    }

}
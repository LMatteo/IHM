package enseigne;

import enseigne.component.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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

    private String imagePath;

    @FXML
    void ajoutMag(ActionEvent event) throws IOException{
        Magasin m = new Magasin();
        m.setAddr(adresse.getText());
        m.setCentre(centreCommercial.getText());
        m.setInfoFr(informationsFr.getText());
        m.setInfoEn(informationsEN.getText());
        m.setWeb(web.getText());
        m.setTelephone(telephone.getText());
        m.setVille(ville.getText());
        m.setCodePostal(codePostal.getText());
        m.setPhoto(imagePath);
        m.write();
    }

    @FXML
    void browsePic(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Photo Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            logoPreview.setImage(Image.impl_fromPlatformImage(file));
            imagePath = file.getPath();
        }
    }

}

package enseigne.adminController;

import enseigne.component.ReadConst;
import enseigne.component.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
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
        m.setVille(ville.getText());
        m.setTelephone(telephone.getText());
        m.setCodePostal(codePostal.getText());
        m.write();
        Stage stage = (Stage) ajoutMagasin.getScene().getWindow();
        stage.close();
    }

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

}

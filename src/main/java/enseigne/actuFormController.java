package enseigne;

/**
 * Created by Josué on 01/03/2017.
 */

import enseigne.component.actu.Actu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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

    @FXML
    void browsePic(ActionEvent event) {
        //toudou quand on sait que ca marche pour magasinFormController
    }

    @FXML
    void ajoutMagasin(ActionEvent event) {
        Actu a = new Actu();
        a.setContentEn(contentEn.getPromptText());
        a.setContentFr(contentFr.getPromptText());
        a.setTitreEn(titreEn.getPromptText());
        a.setTitreFr(titreFr.getPromptText());
        //a.setImage(...);

    }

}


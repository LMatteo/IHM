package enseigne;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;

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
    void browsePic(ActionEvent event) {
        System.out.println("salut");
    }

}
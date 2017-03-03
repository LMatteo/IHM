package enseigne.customerController;

import enseigne.adminController.AdminStoreController;
import enseigne.modele.magasin.Magasin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Objects;

public class MagControl {

    @FXML
    private HBox hbox1;

    @FXML
    private ImageView image;

    @FXML
    private VBox vbox2;

    @FXML
    private Label title;

    @FXML
    private Label info;

    @FXML
    private Label tel;

    @FXML
    private Label addresse;

    private Magasin m ;
    private AdminStoreController controller;

    public void setMagasin(Magasin m ){
        this.m = m;
        if (m.getPhoto() != null) {
            image.setImage(new Image(new File(m.getPhoto()).toURI().toString()));
            image.setFitWidth(200);
            image.setFitHeight(200);
            image.setStyle("-fx-padding: 20px");
        }

        if (Objects.equals(m.getVille(), null)) {
            title.setText("Au centre commercial " + m.getCentre());
        } else {
            title.setText("À "+m.getVille() + ", au centre commercial " + m.getCentre());
        }

        info.setText("Informations complémentaires : "+m.getInfoFr());
        tel.setText("Téléphone : " + m.getTelephone()+" - Site web : " + m.getWeb());
        addresse.setText("Adresse : " + m.getAddr() + " " + m.getCodePostal() + " " + m.getVille());

    }

    @FXML
    void selected(MouseEvent event) {
        if(controller != null){
            controller.selectMag(m);
        }
    }

    public void setController(AdminStoreController controller){
        this.controller = controller;
    }

}

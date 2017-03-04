package enseigne.adminController;

import enseigne.modele.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class AccControlAdmin {

    public static final String color = "#a3d35f";
    public static final String foncey = "#7cb131";

    @FXML
    private ScrollPane pane;

    @FXML
    private Button adminAccueil;

    @FXML
    private Button adminGallerie;

    @FXML
    private Button adminStore;

    @FXML
    private Button adminInfo;

    @FXML
    private Button adminOverview;

    private Button previous;

    private Node accueilPane;
    private Node galeriePane;
    private Node magasinPane;
    private Node overviewPane;
    private Node infoPane;

    @FXML
    public void initialize() throws IOException {
        infoPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/admin/adminInfo.fxml"));
        accueilPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/admin/adminAccueil.fxml"));
        galeriePane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/admin/adminGallerie.fxml"));
        overviewPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/admin/adminOverview.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/adminStore.fxml"));
        magasinPane = loader.load();
        AdminStoreController ctrl = loader.getController();
        ctrl.setFilter(new MagFilter());

    }

    @FXML
    void switchAccueil(ActionEvent event){
        Button source = (Button) event.getSource();
        pane.setContent(accueilPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchGallerie(ActionEvent event) {
        Button source = (Button) event.getSource();
        pane.setContent(galeriePane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchMagasins(ActionEvent event) {
        Button source = (Button) event.getSource();
        pane.setContent(magasinPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchInfos(ActionEvent event) {
        Button source = (Button) event.getSource();
        pane.setContent(infoPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchOverview(ActionEvent event) {
        Button source = (Button) event.getSource();
        pane.setContent(overviewPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    private void switchBut(Button bigButt) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + color + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        bigButt.setStyle("-fx-background-color: " + foncey + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = bigButt;

    }

}

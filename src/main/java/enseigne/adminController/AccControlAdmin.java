package enseigne.adminController;

import enseigne.adminController.overview.overviewController;
import enseigne.adminController.store.AdminStoreController;
import enseigne.modele.MagFilter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccControlAdmin {

    public static final String color = "#a3d35f";
    public static final String foncey = "#7cb131";

    @FXML
    private ScrollPane pane;

    @FXML
    private ToggleButton adminAccueil;

    @FXML
    private ToggleButton adminGallerie;

    @FXML
    private ToggleButton adminStore;

    @FXML
    private ToggleButton adminInfo;

    @FXML
    private ToggleButton adminOverview;

    @FXML
    private Label timeLabel;

    private Button previous;

    private Node accueilPane;
    private Node galeriePane;
    private Node magasinPane;
    private Node overviewPane;
    private Node infoPane;
    private FXMLLoader overviewPaneLoader;
    private FXMLLoader galeriePaneLoader;

    @FXML
    public void initialize() throws IOException {
        infoPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/infos.fxml"));
        accueilPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/admin/adminAccueil.fxml"));
        galeriePaneLoader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/adminGallerie.fxml"));
        galeriePane = galeriePaneLoader.load();
        overviewPaneLoader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/adminOverview.fxml"));
        overviewPane = overviewPaneLoader.load();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/adminStore.fxml"));
        magasinPane = loader.load();
        AdminStoreController ctrl = loader.getController();
        ctrl.setFilter(new MagFilter());
        pane.setContent(accueilPane);

    }

    @FXML
    void switchAccueil(ActionEvent event) {
        pane.setContent(accueilPane);
        pane.setVvalue(0);
    }

    @FXML
    void switchGallerie(ActionEvent event) {
        pane.setContent(galeriePane);
        pane.setVvalue(0);
    }

    @FXML
    void switchMagasins(ActionEvent event) {
        pane.setContent(magasinPane);
        pane.setVvalue(0);
    }

    @FXML
    void switchInfos(ActionEvent event) {
        infoPane.setStyle("-fx-padding: 20px 20px 20px 150px");
        pane.setContent(infoPane);
        pane.setVvalue(0);
    }

    @FXML
    void switchOverview(ActionEvent event) {
        pane.setContent(overviewPane);
        overviewController ctrl = overviewPaneLoader.getController();
        try {
            ctrl.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.setVvalue(0);
    }

    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            Calendar time = Calendar.getInstance();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                            timeLabel.setText(simpleDateFormat.format(time.getTime()));
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}

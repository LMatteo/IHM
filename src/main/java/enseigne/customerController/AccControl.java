package enseigne.customerController;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccControl {
    public static final String color = "#a3d35f";
    public static final String foncey = "#7cb131";

    @FXML
    private ScrollPane pane;

    @FXML
    private Button accueil;

    @FXML
    private Button gallerie;

    @FXML
    private Button magasins;

    @FXML
    private Button infos;
    @FXML
    private Label timeLabel;

    private Button previous;

    private Node accueilPane;
    private Node galeriePane;
    private Node magasinPane;
    private Node infoPane;


    @FXML
    public void initialize() throws IOException {
        accueilPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/accueil.fxml"));
        galeriePane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/gallerie.fxml"));
        magasinPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/magasins.fxml"));
        infoPane = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/infos.fxml"));
        switchBut(accueil);
        pane.setVvalue(0);
        pane.setContent(accueilPane);
        accueil.setCursor(Cursor.HAND);
    }

    private void switchBut(Button bigButt) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + color + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        bigButt.setStyle("-fx-background-color: " + foncey + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = bigButt;

    }

    @FXML
    void switchAccueil(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        pane.setContent(accueilPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchGallerie(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        pane.setContent(galeriePane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchMagasins(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        pane.setContent(magasinPane);
        switchBut(source);
        pane.setVvalue(0);
    }

    @FXML
    void switchInfos(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        pane.setContent(infoPane);
        switchBut(source);
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

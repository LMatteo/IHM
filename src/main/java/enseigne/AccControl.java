package enseigne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

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

    private Button previous;

    @FXML
    public void initialize() throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/fxml/enseigne/customer/accueil.fxml"));
        switchBut(accueil);
        pane.setVvalue(0);
        pane.setContent(box);
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
    void switchPanel(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        String id = source.getId();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/customer/" + id + ".fxml"));
        VBox box = loader.load();
        pane.setContent(box);
        switchBut(source);
        pane.setVvalue(0);
    }

}

package enseigne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AccControlAdmin {

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
    void switchPanel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/" + "adminStore" + ".fxml"));
        Node box = loader.load();
        pane.setContent(box);
    }

}

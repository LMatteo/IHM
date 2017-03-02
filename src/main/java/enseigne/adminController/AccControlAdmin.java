package enseigne.adminController;

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
    private Button adminAccueil;

    @FXML
    private Button adminGallerie;

    @FXML
    private Button adminStore;

    @FXML
    private Button adminInfo;

    @FXML
    void switchPanel(ActionEvent event) throws IOException {
        Button source = (Button) event.getSource();
        String id = source.getId();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/" + id + ".fxml"));
        Node box = loader.load();
        pane.setContent(box);
    }

}

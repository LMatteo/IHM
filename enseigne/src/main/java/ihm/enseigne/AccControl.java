package ihm.enseigne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AccControl {

    @FXML
    private ScrollPane pane;

    @FXML
    private Button accueil;

    @FXML
    private Button gallerie;

    @FXML
    private Button mag;

    @FXML
    private Button info;

    @FXML
    void goToAcc(ActionEvent event) throws IOException{
        VBox box = FXMLLoader.load(getClass().getResource("/home.fxml"));
        pane.setContent(box);
    }

    @FXML
    void goToGal(ActionEvent event) {

    }

    @FXML
    void goToInfo(ActionEvent event) {

    }

    @FXML
    void goToMag(ActionEvent event) {

    }

}

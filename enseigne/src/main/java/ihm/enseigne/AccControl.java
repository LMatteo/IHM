package ihm.enseigne;

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
    private Button mag;

    @FXML
    private Button info;

    private Button previous;
    @FXML
    public void initialize() throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/home.fxml"));
        switchBut(accueil);
        pane.setVvalue(0);
        pane.setContent(box);
        accueil.setCursor(Cursor.HAND);
    }
    @FXML
    void goToAcc(ActionEvent event) throws IOException{
        VBox box = FXMLLoader.load(getClass().getResource("/home.fxml"));
        pane.setContent(box);
        switchBut(accueil);
        pane.setVvalue(0);
    }

    @FXML
    void goToGal(ActionEvent event) throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/gallerie.fxml"));
        pane.setContent(box);
        switchBut(gallerie);
        pane.setVvalue(0);

    }

    @FXML
    void goToInfo(ActionEvent event) throws IOException{
        VBox box = FXMLLoader.load(getClass().getResource("/infos.fxml"));
        pane.setContent(box);
        switchBut(info);
        pane.setVvalue(0);

    }

    @FXML
    void goToMag(ActionEvent event) throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/magasins.fxml"));
        pane.setContent(box);
        switchBut(mag);
        pane.setVvalue(0);
    }

    private void switchBut(Button bigButt){
        if(previous != null){
            previous.setStyle("-fx-background-color: "+color+"; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        bigButt.setStyle("-fx-background-color: "+foncey+"; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = bigButt;

    }

}

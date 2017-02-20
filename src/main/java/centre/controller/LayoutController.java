package centre.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Controller for the main layout of the centre screen.
 */
public class LayoutController {

    private static final String normal = "#4B77BE";
    private static final String active = "#84a5c9";

    @FXML
    private ScrollPane pane;

    @FXML
    private Button actualite;

    @FXML
    private Button boutiques;

    @FXML
    private Button infopratiques;

    private Button previous;
    private AnchorPane ap;

    /**
     * Starts up the interface in the news screen.
     *
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    public void initialize() throws IOException {
        ap = FXMLLoader.load(getClass().getResource("/fxml/centre/news.fxml"));
        switchBut(actualite);
        pane.setVvalue(0);
        pane.setContent(ap);
    }

    /**
     * Switches to the new screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToActu(ActionEvent event) throws IOException {
        ap = FXMLLoader.load(getClass().getResource("/fxml/centre/news.fxml"));
        pane.setContent(ap);
        switchBut(actualite);
        pane.setContent(ap);
    }

    /**
     * Switches to the store screen.
     *
     * @param event - the mouse event of the action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToBoutiques(ActionEvent event) throws IOException {
        ap = FXMLLoader.load(getClass().getResource("/fxml/centre/store.fxml"));
        pane.setContent(ap);
        switchBut(boutiques);
        pane.setVvalue(0);
    }

    /**
     * Switches to the info screen.
     *
     * @param event - the mouse event of this action
     * @throws IOException - if failing to load the fxml
     */
    @FXML
    void goToInfoPratiques(ActionEvent event) throws IOException {
        ap = FXMLLoader.load(getClass().getResource("/fxml/centre/info.fxml"));
        pane.setContent(ap);
        switchBut(infopratiques);
        pane.setVvalue(0);

    }

    private void switchBut(Button current) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + normal + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        current.setStyle("-fx-background-color: " + active + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = current;

    }

}

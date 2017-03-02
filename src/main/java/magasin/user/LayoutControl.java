package magasin.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Controller for the main layout of the boutique screen.
 */
public class LayoutControl {
    public static final String bright = "#b3d287";
    public static final String dark = "#7cb131";

    @FXML private ScrollPane pane;
    @FXML private Button book;
    @FXML private Button media;
    @FXML private Button stage;
    @FXML private Button home;

    private Button previous;
    private ScrollPane sp;

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        sp = FXMLLoader.load(getClass().getResource("/fxml/magasin/user/home.fxml"));
        switchButtonStyle(home);
        pane.setVvalue(0);
        pane.setContent(sp);
        home.setCursor(Cursor.HAND);
    }

    /**
     * Switches the style of the top buttons so that the selected screen appears highlighted.
     *
     * @param current - the last button used
     */
    private void switchButtonStyle(Button current) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + bright + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        current.setStyle("-fx-background-color: " + dark + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = current;
    }


    @FXML
    void goToBook(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/book.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        switchButtonStyle(book);
        pane.setVvalue(0);
    }


    @FXML
    void goToCD(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/media.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        switchButtonStyle(media);
        pane.setVvalue(0);    }



    @FXML
    void goToMall(MouseEvent event) throws IOException {
        //switchScene(event, System.getProperty("user.dir")+ File.separator +"IHM/centre/src/resources/fxml/Actu.fxml");
    }

    @FXML
    void goToStage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/stage.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        switchButtonStyle(stage);
        pane.setVvalue(0);
    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        sp = FXMLLoader.load(getClass().getResource("/fxml/magasin/user/home.fxml"));
        pane.setContent(sp);
        switchButtonStyle(home);
        pane.setContent(sp);
    }




}

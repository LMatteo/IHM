package magasin.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import magasin.admin.BoutiqueInfoControl;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Controller for the main layout of the boutique screen.
 */
public class LayoutControl {
    public static final String bright = "#b3d287";
    public static final String dark = "#7cb131";

    @FXML protected ScrollPane paneLayout;
    @FXML private Button book;
    @FXML private Button media;
    @FXML private Button stage;
    @FXML private Button home;

    private Button previous;
    private ScrollPane sp;

    /**
     * Constructor which loads the homepage directly in the layout when we launch
     * the program
     * @throws IOException
     * @throws URISyntaxException
     */

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/home.fxml"));
        sp = loader.load();
        HomeControl homeControl = loader.getController();
        homeControl.setLayoutControl(this);
        paneLayout.setVvalue(0);
        paneLayout.setContent(sp);
        home.setCursor(Cursor.HAND);
    }

    /**
     * Switches the style of the top buttons so that the selected screen appears darker.
     *
     * @param current - the last button used
     */
    private void switchButtonStyle(Button current) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + bright + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        if(current != null){
            current.setStyle("-fx-background-color: " + dark + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        previous = current;
    }

    /**
     * Methods which loads views from the layout's buttons
     */
    @FXML
    void goToBook(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/book.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(book);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToCD(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/media.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(media);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToMall(MouseEvent event) throws IOException {
        //switchScene(event, System.getProperty("user.dir")+ File.separator +"IHM/centre/src/resources/fxml/Actu.fxml");
    }

    @FXML
    void goToStage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/stage.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stage);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/home.fxml"));
        sp = loader.load();
        HomeControl homeControl = loader.getController();
        homeControl.setLayoutControl(this);
        paneLayout.setContent(sp);
        switchButtonStyle(home);
        paneLayout.setVvalue(0);
    }

    /**
     * Methods which load some views from the client homepage
     **/
    @FXML
    void goToCatalogue(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/catalogue.fxml"));
        ScrollPane sp = loader.load();
        CatalogueControl catControl = loader.getController();
        catControl.setLayoutControl(this);
        paneLayout.setContent(sp);
        switchButtonStyle(null);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToBoutique(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/boutique.fxml"));
        ScrollPane sp = loader.load();
        infoBoutiqueControl infoControl = loader.getController();
        infoControl.setLayoutControl(this);
        infoControl.setElements();
        paneLayout.setContent(sp);
        switchButtonStyle(null);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToActu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/currently.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(null);
        paneLayout.setVvalue(0);
    }

    /**
     * Methods which load some views from the catalogue view
     **/
    @FXML
    void changeToList(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/list_catalogue.fxml"));
        ScrollPane sp = loader.load();
        CatalogueControl catControl = loader.getController();
        catControl.setLayoutControl(this);
        paneLayout.setContent(sp);
        switchButtonStyle(null);
        paneLayout.setVvalue(0);
    }
}

package magasin.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @author Zaki
 */
public class HomeControl {

    @FXML private ScrollPane pane;


    @FXML
    void goToCatalog(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/catalogue.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        pane.setVvalue(0);
    }


    @FXML
    void goToActu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/currently.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        pane.setVvalue(0);
    }

    @FXML
    void goToBoutique(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/user/boutique.fxml"));
        ScrollPane sp = loader.load();
        pane.setContent(sp);
        pane.setVvalue(0);
    }



}

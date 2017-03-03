package magasin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Zaki
 */
public class GoToControl {

    @FXML
    void goToActu(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/currently.fxml");
    }

    @FXML
    void goToBook(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/book.fxml");
    }

    @FXML
    void goToBoutique(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/boutique.fxml");
    }

    @FXML
    void goToCD(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/media.fxml");
    }

    @FXML
    void goToCatalog(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/catalogue.fxml");
    }

    @FXML
    void goToMall(MouseEvent event) throws IOException {
        //switchScene(event, System.getProperty("user.dir")+ File.separator +"IHM/centre/src/resources/fxml/Actu.fxml");
    }

    @FXML
    void goToPromo(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/catalogue.fxml");
    }

    @FXML
    void goToStage(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/stage.fxml");
    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/user/home.fxml");
    }

    private void switchScene(MouseEvent event, String location) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}


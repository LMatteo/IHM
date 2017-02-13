package magasin;

/**
 * @author Zaki
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Catalogue {

    @FXML
    void goToBook(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/Livre.fxml");
    }

    @FXML
    void goToCD(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/Media.fxml");
    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException{
        switchScene(event, "/fxml/Home.fxml");
    }

    @FXML
    void goToMall(MouseEvent event) {

    }

    @FXML
    void goToStage(MouseEvent event) {

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

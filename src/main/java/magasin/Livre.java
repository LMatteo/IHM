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
public class Livre {

    @FXML
    void goToBook(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/Livre.fxml");
    }

    @FXML
    void goToCD(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/Media.fxml");
    }

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/Home.fxml");
    }

    @FXML
    void goToMall(MouseEvent event) throws IOException {
    }

    @FXML
    void goToStage(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/magasin/Stage.fxml");
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

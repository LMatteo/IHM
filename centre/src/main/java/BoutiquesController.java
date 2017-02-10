import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BoutiquesController {

    @FXML
    void switchActu(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/Actu.fxml");
    }

    @FXML
    void switchInfo(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/infopratique.fxml");
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

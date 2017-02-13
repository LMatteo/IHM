package magasin;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import java.io.IOException;

/**
 * @author Zaki
 */

public class Home{

    @FXML
    void goToActu(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/Currently.fxml");
    }

    @FXML
    void goToBook(MouseEvent event) throws IOException{
        switchScene(event, "/fxml/Livre.fxml");
    }

    @FXML
    void goToBoutique(MouseEvent event) {

    }

    @FXML
    void goToCD(MouseEvent event) throws IOException {
        switchScene(event, "/fxml/Media.fxml");
    }

    @FXML
    void goToCatalog(MouseEvent event) throws IOException{
        switchScene(event, "/fxml/Catalogue.fxml");
    }

    @FXML
    void goToMall(MouseEvent event) throws  IOException{
        //switchScene(event, System.getProperty("user.dir")+ File.separator +"IHM/centre/src/resources/fxml/Actu.fxml");
    }

    @FXML
    void goToPromo(MouseEvent event) {

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


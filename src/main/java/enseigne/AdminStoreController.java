package enseigne;

import centre.controller.StoreFormController;
import enseigne.component.ReadConst;
import enseigne.component.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdminStoreController {

    @FXML
    private Button add;

    @FXML
    private VBox pane;

    @FXML
    public void initialize() throws IOException {

        List<Magasin> magasins = ReadConst.getStoresJson();
        for(Magasin mag : magasins){
            pane.getChildren().add(ToNode.magasins(mag));
        }


    }

    @FXML
    void addStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/magasinForm.fxml"));
        Parent rootNode = loader.load();
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

}

package enseigne.adminController;

import enseigne.ToNode;
import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminStoreController {


    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private VBox pane;

    private Magasin selectedMag;

    @FXML
    public void initialize() throws IOException {

        List<Magasin> magasins = ReadConst.getStoreFromJson();
        for(Magasin mag : magasins){
            pane.getChildren().add(ToNode.magasins(mag,this));
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

    @FXML
    void removeStore(ActionEvent event) throws IOException {
        VBox root = new VBox();
        root.setStyle("-fx-padding: 20px");
        root.setSpacing(10);
        List<CheckBox> boxes = new ArrayList<>();
        for(Magasin m : ReadConst.getStoreFromJson()){
            CheckBox c = new CheckBox(m.getCentre());
            c.setStyle("-fx-font-size: 25px;-fx-padding: 5px");
            boxes.add(c);
            root.getChildren().add(c);
        }

        Button b = new Button("Supprimer les magasins sélectionnés");
        b.setStyle("-fx-font-size: 25px");
        root.getChildren().add(b);
        b.setOnAction(event1 -> removeSelected(boxes));
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(root);
        Scene scene = new Scene(scroll,500,500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Suppression");
        stage.show();
    }

    private void removeSelected(List<CheckBox> list){
        Window w = list.get(0).getScene().getWindow();
        for(CheckBox c : list){
            if(c.isSelected()){
                Magasin m = ReadConst.getStoreByCenter(c.getText());
                if(m != null){
                    m.setPath(ReadConst.storePath);
                    m.setName(m.getWeb());
                    m.delete();
                }
            }
        }
        w.hide();
    }

    public void selectMag(Magasin m ){
        selectedMag = m;
        System.out.print(selectedMag);
    }






}

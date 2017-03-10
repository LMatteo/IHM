package enseigne.adminController.store;

import enseigne.ToNode;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AdminStoreController {




    @FXML
    private VBox pane;

    private MagFilter filter;


    public void update() throws IOException {
        pane.getChildren().clear();
        List<Magasin> magasins = filter.toDisplay();
        for(Magasin mag : magasins){
            pane.getChildren().add(ToNode.magasins(mag,this));
        }


    }

    public void setFilter(MagFilter mag) throws IOException{
        this.filter = mag;
        update();
    }

    @FXML
    void addStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/magasinForm.fxml"));
        Parent rootNode = loader.load();
        magasinsFormController ctrl = loader.getController();
        ctrl.setPrevCtrl(this);
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

    @FXML
    void modifyStore(ActionEvent event) throws IOException {
        if(filter.selected() == null) return ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/magasinForm.fxml"));
        Parent rootNode = loader.load();
        magasinsFormController ctrl = loader.getController();
        ctrl.setPrevCtrl(this);
        ctrl.setMag(filter.selected());
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

    public void selectMag(Magasin m ){
        filter.onClick(m);
    }

    public void addMag(Magasin m) throws IOException{
        filter.add(m);
        update();
    }

    @FXML
    public void delOne(ActionEvent event){
        filter.delete();
    }

}

package enseigne.adminController.store;

import enseigne.modele.magasin.Magasin;
import enseigne.modele.MagFilter;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminStoreController {




    @FXML
    private ListView<Magasin> view;
    @FXML
    private TextField filterText;

    private MagFilter filter;


    public void setFilter(MagFilter m){
        this.filter = m ;
        view.setItems(m.toDisplay());
        view.setCellFactory((ListView<Magasin> mag ) -> new MagCell());
        view.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Magasin>() {
            @Override
            public void onChanged(Change<? extends Magasin> c) {
                filter.onClick(view.getSelectionModel().getSelectedItem());
            }
        });

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

    public void selectMag(Magasin m ){
        filter.onClick(m);
    }

    public void addMag(Magasin m) throws IOException{
        filter.delete(m);
        filter.add(m);
    }

    @FXML
    public void delOne(ActionEvent event){
        filter.delete();
    }

    @FXML
    void modifyStore(ActionEvent event) throws IOException {
        if(filter.selected() == null) {
            showAlert("Veuillez sélectionner un magasin à modifier");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/magasinForm.fxml"));
        Parent rootNode = loader.load();
        magasinsFormController ctrl = loader.getController();
        ctrl.setPrevCtrl(this);
        ctrl.setMag(filter.selected());
        ctrl.setModif();
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nouvelle boutique");
        stage.show();
    }

    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur !");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    @FXML
    void setFilter(ActionEvent event) {
        filter.setFilter(filterText.getText());
        filter.filter();
    }

}

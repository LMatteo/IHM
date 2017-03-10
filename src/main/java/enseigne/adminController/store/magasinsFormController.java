package enseigne.adminController.store;

import enseigne.adminController.store.AdminStoreController;
import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class magasinsFormController {

    @FXML
    private TextField centreCommercial;

    @FXML
    private TextField adresse;

    @FXML
    private TextField ville;

    @FXML
    private TextField codePostal;

    @FXML
    private Button browsePhoto;

    @FXML
    private ImageView logoPreview;

    @FXML
    private TextArea informationsFr;

    @FXML
    private TextArea informationsEN;

    @FXML
    private TextField telephone;

    @FXML
    private TextField web;

    @FXML
    private Button ajoutMagasin;

    private String imagePath;
    private AdminStoreController prevCtrl;
    private Magasin m;

    @FXML
    public void initialize(){
        m = new Magasin();
    }

    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void ajoutMag(ActionEvent event) throws IOException{
        m.setAddr(adresse.getText());
        m.setCentre(centreCommercial.getText());
        m.setInfoFr(informationsFr.getText());
        m.setInfoEn(informationsEN.getText());
        m.setWeb(web.getText());
        m.setTelephone(telephone.getText());
        m.setVille(ville.getText());
        m.setCodePostal(codePostal.getText());
        File image = new File(imagePath);
        m.setPhoto(ReadConst.imagePath+'/'+image.getName());
        m.setVille(ville.getText());
        m.setTelephone(telephone.getText());
        m.setCodePostal(codePostal.getText());

        // filling a map - TO DELETE when lucas aura fait son taf
        Random r = new Random();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0;i<5;i++){
            map1.put(i,r.nextInt(100)+1);
            map2.put(i,r.nextInt(100)+1);
        }
        m.setAge(map1);
        m.setPointe(map2);
        //end of  TO DELETE//
        prevCtrl.addMag(m);
        Stage stage = (Stage) ajoutMagasin.getScene().getWindow();
        stage.close();
    }

    @FXML
    void browsePic(ActionEvent event) throws FileNotFoundException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Photo Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            logoPreview.setImage(image);
            File out = new File(ReadConst.imagePath+"/"+file.getName());
            try {
                FileUtils.copyFile(file,out);
                imagePath = out.getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPrevCtrl(AdminStoreController ctrl){
        this.prevCtrl = ctrl;
    }

    public void setMag(Magasin m){
        this.m = m ;
        centreCommercial.setText(m.getCentre());
        adresse.setText(m.getAddr());
        ville.setText(m.getVille());
        codePostal.setText(m.getCodePostal());
        try {
            logoPreview.setImage(new Image(m.getPhoto()));
        }catch (Exception e){}
        informationsFr.setText(m.getInfoFr());
        informationsEN.setText(m.getInfoEn());
        telephone.setText(m.getTelephone());
        web.setText(m.getWeb());
        imagePath = m.getPhoto();
    }

}

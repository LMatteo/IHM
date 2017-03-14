package magasin.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import magasin.modele.boutiqueInformation.BoutiqueInformation;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Zaki
 */
public class BoutiqueInfoControl {

    @FXML private TextField openTime;
    @FXML private TextField closeTime;
    @FXML private TextArea descrFr;
    @FXML private TextArea descrEng;
    @FXML private Button browsePic1;
    @FXML private Button browsePic2;
    @FXML private Button browsePic3;
    @FXML private Button browsePic4;
    @FXML private ImageView picPrev1;
    @FXML private ImageView picPrev2;
    @FXML private ImageView picPrev3;
    @FXML private ImageView picPrev4;
    @FXML private Button saveInfo;

    private AdminLayoutControl adminLayoutControl;
    private BoutiqueInformation boutiqueInfo;
    private String imagePath1;
    private String imagePath2;
    private String imagePath3;
    private String imagePath4;

    @FXML
    public void initialize(){
        boutiqueInfo = new BoutiqueInformation();
    }

    public void setAdminLayoutControl(AdminLayoutControl adminLayoutControl) {
        this.adminLayoutControl = adminLayoutControl;
    }

    @FXML
    void BrowsePic(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Charger une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Photo Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            if(event.getSource().equals(browsePic1)) {
                picPrev1.setImage(image);
                File out = new File("data/magasin/info/image1_" + file.getName());
                try {
                    FileUtils.copyFile(file,out);
                    imagePath1 = out.getPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource().equals(browsePic2)) {
                picPrev2.setImage(image);
                File out = new File("data/magasin/info/image2_"+ file.getName());
                try {
                    FileUtils.copyFile(file,out);
                    imagePath2 = out.getPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource().equals(browsePic3)) {
                picPrev3.setImage(image);
                File out = new File("data/magasin/info/image3_"+ file.getName());
                try {
                    FileUtils.copyFile(file,out);
                    imagePath3 = out.getPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource().equals(browsePic4)) {
                picPrev4.setImage(image);
                File out = new File("data/magasin/info/image4_"+ file.getName());
                try {
                    FileUtils.copyFile(file,out);
                    imagePath4 = out.getPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @FXML
    void SaveInfo(MouseEvent event) throws IOException{
        boutiqueInfo.setOpenTime(openTime.getText());
        boutiqueInfo.setCloseTime(closeTime.getText());
        boutiqueInfo.setDescrFr(descrFr.getText());
        boutiqueInfo.setDescrEng(descrEng.getText());
        if(imagePath1 != null) {
            File image = new File(imagePath1);
            boutiqueInfo.setPathPic1("data/magasin/info/" + image.getName());
        }
        if(imagePath2 != null) {
            File image = new File(imagePath2);
            boutiqueInfo.setPathPic2("data/magasin/info/" + image.getName());
        }
        if(imagePath3 != null) {
            File image = new File(imagePath3);
            boutiqueInfo.setPathPic3("data/magasin/info/" + image.getName());
        }
        if(imagePath4 != null) {
            File image = new File(imagePath4);
            boutiqueInfo.setPathPic4("data/magasin/info/" + image.getName());
        }
        boutiqueInfo.write();
    }





}

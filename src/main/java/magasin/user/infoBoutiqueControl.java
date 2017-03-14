package magasin.user;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import magasin.modele.BoutiqueInformation.BoutiqueInformation;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import static magasin.modele.BoutiqueInformation.BoutiqueInformationAttribute.closeTime;

/**
 * @author Zaki
 */
public class infoBoutiqueControl {

    @FXML private Text description;
    @FXML private Label openTime;
    @FXML private Label closingTime;
    //@FXML private Hyperlink location;
    @FXML private Label phoneNumber;
    @FXML private ImageView pic1;
    @FXML private ImageView pic2;
    @FXML private ImageView pic3;
    @FXML private ImageView pic4;

    private BoutiqueInformation boutiqueInfo;
    private LayoutControl layoutControl;

    public void setLayoutControl(LayoutControl layoutControl) {
        this.layoutControl = layoutControl;
    }

    @FXML void setElements()throws IOException{
        boutiqueInfo = new BoutiqueInformation("data/magasin/info/info.json");
        openTime.setText(boutiqueInfo.getOpenTime());
        closingTime.setText(boutiqueInfo.getCloseTime());
        description.setText(boutiqueInfo.getDescrFr());
        phoneNumber.setText(boutiqueInfo.getPhoneNumber());
        File file1 = new File(System.getProperty("user.dir")+boutiqueInfo.getPathPic1());
        Image image1 = new Image(file1.toURI().toString());
        pic1 = new ImageView(image1);
        File file2 = new File(System.getProperty("user.dir")+boutiqueInfo.getPathPic2());
        Image image2 = new Image(file2.toURI().toString());
        pic2 = new ImageView(image2);
        File file3 = new File(System.getProperty("user.dir")+boutiqueInfo.getPathPic3());
        Image image3 = new Image(file3.toURI().toString());
        pic3 = new ImageView(image3);
        File file4 = new File(System.getProperty("user.dir")+boutiqueInfo.getPathPic4());
        Image image4 = new Image(file4.toURI().toString());
        pic1 = new ImageView(image4);

    }


    @FXML void showLocation(MouseEvent event) {

    }
}

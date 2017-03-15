package magasin.user;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import magasin.modele.boutiqueInformation.BoutiqueInformation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author Zaki
 */
public class infoBoutiqueControl {

    @FXML
    private Text description;
    @FXML
    private Label openTime;
    @FXML
    private Label closingTime;
    @FXML
    private Label phoneNumber;
    @FXML
    private ImageView pic1;
    @FXML
    private ImageView pic2;
    @FXML
    private ImageView pic3;
    @FXML
    private ImageView pic4;
    @FXML
    private ScrollPane paneBoutique;

    private BoutiqueInformation boutiqueInfo;
    private LayoutControl layoutControl;

    public void setLayoutControl(LayoutControl layoutControl) {
        this.layoutControl = layoutControl;
    }

    @FXML
    void setElements() throws IOException {
        boutiqueInfo = new BoutiqueInformation("data/magasin/info/info.json");
        openTime.setText(boutiqueInfo.getOpenTime());
        closingTime.setText(boutiqueInfo.getCloseTime());
        description.setText(boutiqueInfo.getDescrFr());
        phoneNumber.setText(boutiqueInfo.getPhoneNumber());

        if (boutiqueInfo.getPathPic1() != null) {
            pic1.setImage(new Image(new File(boutiqueInfo.getPathPic1()).toURI().toString()));
            pic1.setFitWidth(404);
            pic1.setFitHeight(325);
        }
        if (boutiqueInfo.getPathPic2() != null) {
            pic2.setImage(new Image(new File(boutiqueInfo.getPathPic2()).toURI().toString()));
            pic2.setFitWidth(404);
            pic2.setFitHeight(325);
        }
        if (boutiqueInfo.getPathPic3() != null) {
            pic3.setImage(new Image(new File(boutiqueInfo.getPathPic3()).toURI().toString()));
            pic3.setFitWidth(404);
            pic3.setFitHeight(325);
        }
        if (boutiqueInfo.getPathPic4() != null) {
            File file = new File(boutiqueInfo.getPathPic4());
            pic4.setImage(new Image(new File(boutiqueInfo.getPathPic4()).toURI().toString()));
            pic4.setFitWidth(404);
            pic4.setFitHeight(325);
        }

    }

    @FXML
    void showLocation(MouseEvent event) {
        Group root = new Group();
        Scene scene = new Scene(root, 427, 319);
        Stage stage = new Stage();

        File file = new File("data/magasin/info/map.png");
        ImageView pic = new ImageView();
        pic.setImage(new Image(file.toURI().toString()));
        root.getChildren().add(pic);

        stage.setScene(scene);
        stage.setTitle("Plan");
        stage.show();
    }
}

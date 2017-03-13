package enseigne;

import enseigne.adminController.store.AdminStoreController;
import enseigne.customerController.MagControl;
import enseigne.customerController.PhotoControl;
import enseigne.modele.photo.Photo;
import enseigne.modele.actu.Actu;
import enseigne.modele.magasin.Magasin;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class ToNode {

    public static Node magasins(Magasin m, AdminStoreController controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(ToNode.class.getResource("/fxml/enseigne/customer/magDisplay.fxml"));
        Node node = loader.load();
        MagControl ctrl  = (MagControl)loader.getController();
        ctrl.setMagasin(m);
        ctrl.setController(controller);
        return node;

    }

    public static Node actu(Actu a) {
        HBox hbox1 = new HBox();
        ImageView img = new ImageView();
        if (a.getImage() != null) {
            img.setImage(new Image(new File(a.getImage()).toURI().toString()));
            img.setFitWidth(200);
            img.setFitHeight(200);
        }
        if (a.isBigSize()) {
            hbox1.getChildren().add(img);
            VBox vbox2 = new VBox();
            Label l1 = new Label(a.getTitreFr());
            Label l2 = new Label(a.getContentFr());
            vbox2.getChildren().addAll(l1, l2);
            hbox1.getChildren().add(vbox2);

        } else {
            VBox vbox2 = new VBox();
            vbox2.getChildren().add(img);
            vbox2.getChildren().addAll(new Label(a.getTitreFr()), new Label(a.getContentFr()));
        }
        return hbox1;
    }

    public static Node photos(Photo p) throws IOException {
        FXMLLoader loader = new FXMLLoader(ToNode.class.getResource("/fxml/enseigne/customer/photoDisplay.fxml"));
        Node node = loader.load();
        HBox.setMargin(node,new Insets(20,70,20,70));
        PhotoControl ctrl  = (PhotoControl) loader.getController();
        ctrl.setPhoto(p);
        return node;
    }
}

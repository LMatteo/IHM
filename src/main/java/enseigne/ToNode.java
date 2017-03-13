package enseigne;

import enseigne.adminController.store.AdminStoreController;
import enseigne.customerController.galerie.PhotoControl;
import enseigne.customerController.news.NewsControl;
import enseigne.customerController.store.MagControl;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.photo.Photo;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

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

    public static Node news(Image i) throws IOException {
        FXMLLoader loader = new FXMLLoader(ToNode.class.getResource("/fxml/enseigne/customer/newsDisplay.fxml"));
        Node node = loader.load();
        NewsControl ctrl = (NewsControl)loader.getController();
        ctrl.setImage(i);
        return node;
    }

    public static Node photos(Photo p) throws IOException {
        FXMLLoader loader = new FXMLLoader(ToNode.class.getResource("/fxml/enseigne/customer/photoDisplay.fxml"));
        Node node = loader.load();
        HBox.setMargin(node,new Insets(20,20,20,20));
        PhotoControl ctrl  = (PhotoControl) loader.getController();
        ctrl.setPhoto(p);
        return node;
    }
}

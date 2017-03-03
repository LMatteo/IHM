package enseigne;

import enseigne.component.photo.Photo;
import enseigne.component.actu.Actu;
import enseigne.component.magasin.Magasin;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Objects;

public class ToNode {

    public static Node magasins(Magasin m) {
        HBox hbox1 = new HBox();
        ImageView p = new ImageView();

        if (m.getPhoto() != null) {
            p.setImage(new Image(new File(m.getPhoto()).toURI().toString()));
            p.setFitWidth(200);
            p.setFitHeight(200);
            p.setStyle("-fx-padding: 20px");
        }
        VBox vbox2 = new VBox();
        Label label1 = new Label();
        System.out.println(m.getVille());
        if (Objects.equals(m.getVille(), null)) {
            label1.setText("Au centre commercial " + m.getCentre());
        } else {
            label1.setText("À "+m.getVille() + ", au centre commercial " + m.getCentre());
        }

        Label label2 = new Label(m.getInfoFr());
        Label label3 = new Label("Téléphone : " + m.getTelephone()+" - Site web : " + m.getWeb());
        Label label5 = new Label("Adresse : " + m.getAddr() + " " + m.getCodePostal() + " " + m.getVille());
        HBox hbox3 = new HBox();
        hbox3.getChildren().add(label3);

        vbox2.getChildren().add(label1);
        vbox2.getChildren().add(label2);
        vbox2.getChildren().add(hbox3);
        vbox2.getChildren().add(label5);


        hbox1.getChildren().add(p);
        hbox1.getChildren().add(vbox2);

        hbox1.setId("hbox1");
        vbox2.setId("vbox2");
        label1.setId("title");
        return hbox1;
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

    public static Node photos(Photo p) {
        HBox hbox1 = new HBox();
        VBox vBox2 = new VBox();
        ImageView img = new ImageView();
        if (p.getPhoto() != null) {
            img.setImage(new Image(new File(p.getPhoto()).toURI().toString()));
            img.setFitWidth(200);
            img.setFitHeight(200);
        }
        vBox2.getChildren().addAll(new Label(p.getTitreFr()), img);
        Label l = new Label("Catégorie : " + p.getCategory());
        Label ll = new Label("Description : " + p.getDescriptionFr());
        vBox2.getChildren().addAll(ll, l);
        return hbox1;
    }
}

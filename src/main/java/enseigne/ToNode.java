package enseigne;

import enseigne.component.Photo;
import enseigne.component.actu.Actu;
import enseigne.component.magasin.Magasin;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class ToNode {

    public static Node magasins(Magasin m){
        HBox hbox1 = new HBox();
        ImageView p = new ImageView();
        if(m.getPhoto() != null) {
            p.setImage(new Image(new File(m.getPhoto()).toURI().toString()));
            p.setFitWidth(200);
            p.setFitHeight(200);
        }
        VBox vbox2 = new VBox();
        Label label1 = new Label(m.getVille()+", au centre commercial "+m.getCentre());
        Label label2 = new Label(m.getInfoFr());
        Label label3 = new Label("Téléphone : "+m.getTelephone());
        Label label4 = new Label("Site web : "+m.getWeb());
        Label label5 = new Label("Adresse : "+m.getAddr()+"\n"+m.getCodePostal()+" "+m.getVille());
        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(label3,label4);

        vbox2.getChildren().add(label1);
        vbox2.getChildren().add(label2);
        vbox2.getChildren().add(hbox3);
        vbox2.getChildren().add(label5);


        hbox1.getChildren().add(p);
        hbox1.getChildren().add(vbox2);

        return hbox1;
    }

    public static Node actu(Actu actu){


    }

    public static Node photos(Photo p){
        return null;
    }
}

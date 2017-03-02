package enseigne;

import enseigne.component.magasin.Magasin;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;

public class testMain extends Application {
        @Override
        public void start(Stage primaryStage) {
            Magasin mag = new Magasin();
            mag.setAddr("31 avenue de salut");
            mag.setChiffreAffaire(10);
            HashMap<Integer,Integer> age = new HashMap<>();
            age.put(10,50);
            age.put(11,80);
            age.put(12,90);
            mag.setAge(age);
            mag.setVille("valbonne");
            mag.setCentre("centre de sophia");
            mag.setInfoFr("on est la ");
            mag.setInfoEn("there we are");
            mag.setCodePostal("06600");
            mag.setTelephone("0614772435");
            mag.setMaint(100);
            mag.setNbEmpl(2);
            mag.setPhoto("/home/luqua/IdeaProjects/IHM/src/main/resources/images/common/flags/france.png");
            mag.setRendu(500);
            mag.setWeb("salut.fr");

            Scene scene = new Scene((Parent) storeToNode(mag), 1060, 200, Color.rgb(0, 0, 0, 0));
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

        public static Node storeToNode(Magasin m){
            HBox hbox1 = new HBox();
            AnchorPane p = new AnchorPane();
            p.setPrefHeight(100);
            p.setPrefWidth(200);
            p.setStyle("-fx-background-color: red");
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
    }

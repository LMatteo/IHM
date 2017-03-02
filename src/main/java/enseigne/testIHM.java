package enseigne;

import enseigne.component.ReadConst;
import enseigne.component.actu.Actu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*from   w w w. j a  v  a  2s  . c o m*/
public class testIHM extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField myTextField = new TextField();
        Actu a = new Actu();

        HBox hbox = (HBox) ReadConst.actuToNode(a);
        ToggleGroup g = new ToggleGroup();
        RadioButton r1 = new RadioButton("a");
        RadioButton r2 = new RadioButton("b");
        RadioButton r3 = new RadioButton("c");
        r1.setToggleGroup(g);
        r2.setToggleGroup(g);
        r3.setToggleGroup(g);
        hbox.getChildren().add(r1);
        hbox.getChildren().add(r2);
        hbox.getChildren().add(r3);



        Scene scene = new Scene(hbox, 320, 112, Color.rgb(0, 0, 0, 0));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
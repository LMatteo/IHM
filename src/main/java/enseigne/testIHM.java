package enseigne;

import enseigne.modele.actu.Actu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/*from   w w w. j a  v  a  2s  . c o m*/
public class testIHM extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField myTextField = new TextField();
        Actu a = new Actu();

        HBox hbox = new HBox();



        Scene scene = new Scene(hbox, 320, 112, Color.rgb(0, 0, 0, 0));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
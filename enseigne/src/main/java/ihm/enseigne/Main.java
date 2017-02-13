package ihm.enseigne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/skel.fxml"));
        primaryStage.setTitle("salut");
        primaryStage.setScene(new Scene(root, 1280, 1024));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

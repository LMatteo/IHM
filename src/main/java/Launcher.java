import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guillaume Andre
 */
public class Launcher extends Application {

    private static final String INVALID_ARGS = "Invalid arguments. Possible arguments are one of the following : (-a) (--centre | --enseigne |" +
            " --magasin) \nCheck Readme for more information. ";

    private static String path = "/fxml/centre/layout.fxml";
    private List<String> styles = new ArrayList<>();

    public void parseArgs(String[] args) {
        if (args.length == 0) {
            launch();
            return;
        }
        if (args.length > 2) {
            exit();
        }
        boolean adminMode = false;
        int firstIndex = 0;
        if (args.length == 2) {
            if (args[0].equals("-a")) {
                adminMode = true;
                firstIndex++;
            } else {
                exit();
            }
        }
        switch (args[firstIndex]) {
            case "--centre":
                if (!adminMode) {
                    path = "/fxml/centre/layout.fxml";
                } else {

                }
                break;
            case "--enseigne":
                if (!adminMode) {
                    path = "/fxml/enseigne/skel.fxml";
                } else {

                }
                break;
            case "--magasin":
                if (!adminMode) {
                    path = "/fxml/magasin/Home.fxml";
                    styles.add("/styles/magasin/styles.css");
                } else {

                }
                break;
            default:
                exit();
        }
        launch();
    }

    private void exit() {
        System.out.println(INVALID_ARGS);
        System.exit(1);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(rootNode, 1280, 1024);
        for (String style : styles) {
            scene.getStylesheets().add(style);
        }
        stage.setTitle("Borne");
        stage.setScene(scene);
        stage.show();
    }


}

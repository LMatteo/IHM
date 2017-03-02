import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Launcher class used to parse the program arguments and starting up the first fxml controller.
 *
 * @author Guillaume Andre
 */
public class Launcher extends Application {

    private static final String INVALID_ARGS = "Invalid arguments. Possible arguments are one of the following : (-a) (--centre | --enseigne |" +
            " --magasin) \nCheck Readme for more information. ";

    private static String path = "/fxml/centre/user/layout.fxml";
    private List<String> styles = new ArrayList<>();
    private static boolean adminMode = false;

    /**
     * Analyzes the arguments of the program, and launches the requested fxml.
     *
     * @param args - the program arguments
     */
    public void parseArgs(String[] args) {
        if (args.length == 0) {
            launch();
            return;
        }
        if (args.length > 2) {
            exit();
        }
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
                    path = "/fxml/centre/user/layout.fxml";
                } else {
                    path = "fxml/centre/admin/adminLayout.fxml";
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

    /**
     * Quits the program in case wrong arguments were used.
     */
    private void exit() {
        System.out.println(INVALID_ARGS);
        System.exit(1);
    }

    /**
     * Starts up the interface.
     *
     * @param stage - the stage of the interface
     * @throws IOException - if failing to open the fxml
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource(path));
        Scene scene = adminMode ? new Scene(rootNode, 1600, 900) : new Scene(rootNode, 1280, 1024);
        for (String style : styles) {
            scene.getStylesheets().add(style);
        }
        stage.setTitle("Borne");
        stage.setScene(scene);
        stage.show();
    }


}

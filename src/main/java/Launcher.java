import centre.constant.AlertMessage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class used to parse the program arguments and starting up the first fxml controller.
 *
 * @author Guillaume Andre
 */
public class Launcher extends Application {

    private static final String INVALID_ARGS = "Invalid arguments. Possible arguments are one of the following : (-a) (--centre | --enseigne |" +
            " --magasin) \nCheck Readme for more information. ";

    private static Map<String, String> PATHS;
    private static Map<String, String> PATHS_ADMIN;

    static {
        PATHS = new HashMap<>();
        PATHS.put("--centre", "/fxml/centre/user/layout.fxml");
        PATHS.put("--enseigne", "/fxml/enseigne/customer/skel.fxml");
        PATHS.put("--magasin", "/fxml/magasin/user/layout.fxml");
        PATHS_ADMIN = new HashMap<>();
        PATHS_ADMIN.put("--centre", "/fxml/centre/admin/adminLayout.fxml");
        PATHS_ADMIN.put("--enseigne", "/fxml/enseigne/admin/skelAdmin.fxml");
        PATHS_ADMIN.put("--magasin", "/fxml/magasin/admin/Admin_Home.fxml");
    }

    private String part = "--centre";
    private List<String> styles = new ArrayList<>();
    private boolean adminMode = false;

    /**
     * Analyzes the arguments of the program.
     */
    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        for (String arg : args) {
            switch (arg) {
                case "-a":
                    adminMode = true;
                    break;
                case "--centre":
                case "--enseigne":
                case "--magasin":
                    part = arg;
                    break;
                default:
                    exit();
            }
        }
    }

    /**
     * Displays an error message, then quits the program.
     */
    private void exit() {
        System.out.println(INVALID_ARGS);
        AlertMessage.alert(Alert.AlertType.ERROR, "Mauvais arguments utilisés", "Par défaut, la vue client du" +
                " centre sera chargée. Veuillez vous référer au readme pour plus d'informations sur les " +
                "arguments disponibles.");
        System.exit(1);
    }

    /**
     * Starts up the interface.
     *
     * @param stage - the main stage of the application
     * @throws IOException - if failing to open the fxml
     */
    @Override
    public void start(Stage stage) throws IOException {
        String path;
        if (adminMode) {
            path = PATHS_ADMIN.get(part);
        } else {
            path = PATHS.get(part);
        }
        Parent rootNode = FXMLLoader.load(getClass().getResource(path));
        Scene scene = adminMode ? new Scene(rootNode, 1600, 900) : new Scene(rootNode, 1280, 1024);
        for (String style : styles) {
            scene.getStylesheets().add(style);
        }
        stage.setTitle("Borne");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

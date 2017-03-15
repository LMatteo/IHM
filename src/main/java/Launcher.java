
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
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
        PATHS_ADMIN.put("--magasin", "/fxml/magasin/admin/Admin_Layout.fxml");
    }

    private String part = "--centre";
    private String style;
    private boolean alternateStyle;
    private boolean adminMode = false;
    private double adminWidth = 1600;
    private double adminHeight = 900;

    public static void main(String[] args) {
        Application.launch(args);
    }

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
                case "--alternate":
                    alternateStyle = true;
                    CentrePaths.PATHTOLOGO = "/images/centre/logoCentre2.png";
                    break;
                case "--magasin":
                    if (adminMode) {
                        adminHeight = 800;
                        adminWidth = 1060;
                    }
                case "--enseigne":
                    part = arg;
                    break;
                case "--centre" :
                    break;
                default:
                    exit();
            }
        }
        if (part.equals("--centre")) {
            if (!adminMode) {
                style = alternateStyle ? "/styles/centre/style2.css" : "/styles/centre/style1.css";
            } else {
                style = "/styles/centre/styleAdmin.css";
            }
        }
    }

    /**
     * Displays an error message, then quits the program.
     */
    private void exit() {
        System.out.println(INVALID_ARGS);
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
        Scene scene = adminMode ? new Scene(rootNode, adminWidth, adminHeight) : new Scene(rootNode, 1280, 1024);
        if (style != null) {
            scene.getStylesheets().add(style);
        }
        stage.setTitle("Borne");
        stage.setScene(scene);
        stage.getIcons().add(new Image(CentrePaths.PATHTOLOGO));
        stage.show();
    }


}

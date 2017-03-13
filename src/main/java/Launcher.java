import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.aerofx.AeroFX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Class used to parse the program arguments and starting up the first fxml controller.
 *
 * @author Guillaume Andre
 */
public class Launcher extends Application {

    private static final String INVALID_ARGS = "Invalid arguments. Possible arguments are one of the following : (-a) (--centre | --enseigne |" +
            " --magasin) \nCheck Readme for more information. ";

    private String path = "/fxml/centre/user/layout.fxml";
    private List<String> styles = new ArrayList<>();
    private boolean adminMode = false;

    /**
     * Analyzes the arguments of the program, and launches the requested fxml.
     */
    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        if (args.size() == 0) {
            return;
        }
        if (args.size() > 2) {
            exit();
        }
        int firstIndex = 0;
        if (args.size() == 2) {
            if (args.get(0).equals("-a")) {
                adminMode = true;
                firstIndex++;
            } else {
                exit();
            }
        }
        switch (args.get(firstIndex)) {
            case "--centre":
                if (!adminMode) {
                    path = "/fxml/centre/user/layout.fxml";
                } else {
                    path = "fxml/centre/admin/adminLayout.fxml";
                }
                break;
            case "--enseigne":
                if (!adminMode) {
                    path = "/fxml/enseigne/customer/skel.fxml";
                } else {
                    path = "/fxml/enseigne/admin/skelAdmin.fxml";
                }
                break;
            case "--magasin":
                if (!adminMode) {
                    path = "/fxml/magasin/user/layout.fxml";
                   // styles.add("/styles/magasin/styles.css");
                } else {

                }
                break;
            default:
                exit();
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
        
        try {
            Parent rootNode = FXMLLoader.load(getClass().getResource(path));
            Scene scene = adminMode ? new Scene(rootNode, 1600, 900) : new Scene(rootNode, 1280, 1024);
            for (String style : styles) {
                scene.getStylesheets().add(style);
            }
            stage.setTitle("Borne");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}

package centre.admin.info;

import centre.constant.CentrePaths;
import centre.model.Informations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the information editor screen.
 */
public class EditInfoController {

    @FXML private ImageView mapPic;
    @FXML private TextField lineFrench1;
    @FXML private TextField lineFrench2;
    @FXML private TextField lineFrench3;
    @FXML private TextField lineFrench4;
    @FXML private TextField lineEnglish1;
    @FXML private TextField lineEnglish2;
    @FXML private TextField lineEnglish3;
    @FXML private TextField lineEnglish4;

    private List<TextField> french;
    private List<TextField> english;
    private File image;

    /**
     * Puts the loaded textfields in lists for easier access.
     */
    @FXML
    public void initialize() {
        french = new ArrayList<>();
        french.add(lineFrench1);
        french.add(lineFrench2);
        french.add(lineFrench3);
        french.add(lineFrench4);
        english = new ArrayList<>();
        english.add(lineEnglish1);
        english.add(lineEnglish2);
        english.add(lineEnglish3);
        english.add(lineEnglish4);
    }

    /**
     * Opens a file chooser to pick the new picture for the map.
     *
     * @param event - the event of this action
     * @throws MalformedURLException - if failing to open the image
     */
    @FXML
    void editPic(ActionEvent event) throws MalformedURLException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir l'image de la nouvelle map");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.png"));
        image = chooser.showOpenDialog(new Stage());
        if (image != null) {
            mapPic.setImage(new Image(image.toURI().toURL().toString()));
        }
    }

    /**
     * Confirms the new map picture and deletes the old one.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to copy or create the file
     */
    @FXML
    void confirmPic(ActionEvent event) throws IOException {
        if (image != null) {
            File newPic = new File("data/centre/images/map/map.png");
            newPic.createNewFile();
            Files.copy(image.toPath(), newPic.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /**
     * Reloads the original informational text.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to read the info file
     */
    @FXML
    void undoText(ActionEvent event) throws IOException {
        initializeContent();
        image = null;
    }

    /**
     * Loads the current informational text and the map picture into the editor.
     *
     * @throws IOException - if failing to load the file or the pic
     */
    public void initializeContent() throws IOException {
        mapPic.setImage(new Image(CentrePaths.getMapPath()));
        Informations info = new Informations();
        List<String> linesFrench = info.getFrench();
        List<String> linesEnglish = info.getEnglish();
        for (int i = 0; i < linesFrench.size(); i++) {
            french.get(i).setText(linesFrench.get(i));
            english.get(i).setText(linesEnglish.get(i));
        }
    }

    /**
     * Saves the changes done to the informational text.
     *
     * @param event - the event of this action
     * @throws IOException - if failing to save the info file
     */
    @FXML
    void confirmText(ActionEvent event) throws IOException {
        List<String> linesFrench = new ArrayList<>();
        List<String> linesEnglish = new ArrayList<>();
        for (int i = 0; i < french.size(); i++) {
            linesFrench.add(french.get(i).getText());
            linesEnglish.add(english.get(i).getText());
        }
        Informations info = new Informations(linesFrench, linesEnglish);
        info.save();
    }

}

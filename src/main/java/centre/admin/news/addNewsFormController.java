package centre.admin.news;

import centre.constant.AlertMessage;
import centre.model.News;
import centre.model.NewsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Controller class for adding new News(promotion)
 */
public class addNewsFormController {

    @FXML TextField name;
    @FXML ToggleGroup orientation;
    @FXML RadioButton vertical;
    @FXML RadioButton horizontal;
    @FXML Button fr;
    @FXML Button en;
    private File imageFR;
    private File imageEN;
    private NewsList newsList;

    public void setNewsList(NewsList nl) {
        this.newsList = nl;
    }

    @FXML
    public void browsePic(ActionEvent e) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir l'image du logo de la boutique");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg"));
        File image = chooser.showOpenDialog(new Stage());
        if (image == null) {
            AlertMessage.alert(Alert.AlertType.WARNING, "Image invalide", "Vous n'avez pas renseigné d'image pour cette promotion");
        }
        if (e.getSource().equals(fr)) {
            imageFR = image;
        } else {
            imageEN = image;
        }
    }

    @FXML
    public void confirm(ActionEvent e) throws IOException {
        if (nameValid() && imagesValid()) {
            News news = new News(name.getText(), getExtension(imageFR), getExtension(imageEN), horizontal.isSelected());
            File newFR = new File("data/centre/images/promo/" + news.getFrench());
            File newEN = new File("data/centre/images/promo/" + news.getEnglish());
            newFR.createNewFile();
            newEN.createNewFile();
            Files.copy(imageFR.toPath(), newFR.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageEN.toPath(), newEN.toPath(), StandardCopyOption.REPLACE_EXISTING);
            news.save();
            newsList.add(news);
            Stage stage = (Stage) name.getScene().getWindow();
            stage.close();
        }
    }

    private boolean nameValid() {
        if (name.getText().equals("")) {
            AlertMessage.alert(Alert.AlertType.WARNING, "Nom vide", "Vous n'avez pas renseigné de nom pour la promotion");
            return false;
        }
        if (newsList.nameExists(name.getText())) {
            AlertMessage.alert(Alert.AlertType.ERROR, "Nom déjà utilisé", "Il existe déjà une promotion avec ce nom");
            return false;
        }
        if (name.getText().length() > 60) {
            AlertMessage.alert(Alert.AlertType.ERROR, "Nom trop long", "Veuillez utiliser un nom plus court");
            return false;
        }
        return true;
    }

    private boolean imagesValid() {
        if (imageFR == null) {
            AlertMessage.alert(Alert.AlertType.ERROR, "image vide", "Vous n'avez pas renseigné d'image pour la version française de cette promotion / actu");
            return false;
        }
        if (imageEN == null) {
            AlertMessage.alert(Alert.AlertType.ERROR, "image vide", "Vous n'avez pas renseigné d'image pour la version anglaise de cette promotion / actu");
            return false;
        }
        return true;
    }

    /**
     * Gets the extension of a file
     *
     * @return the extension
     */
    private String getExtension(File image) {
        return image.getName().substring(image.getName().lastIndexOf("."));
    }
}

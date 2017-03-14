package magasin.user;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author Zaki
 */
public class HomeControl {

    private LayoutControl layoutControl;

    public void setLayoutControl(LayoutControl layoutControl) {
        this.layoutControl = layoutControl;
    }

    @FXML
    void goToCatalogue(MouseEvent event) throws IOException {
        layoutControl.goToCatalogue(null);
    }

    @FXML
    void goToActu(MouseEvent event) throws IOException {
        layoutControl.goToActu(null);
    }

    @FXML
    void goToBoutique(MouseEvent event) throws IOException {
        layoutControl.goToBoutique(null);
    }

}

package magasin.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

/**
 * @author Zaki
 */
public class HomeControl {

    @FXML
    private ScrollPane paneHome;
    @FXML
    private AnchorPane apHome;

    private AnchorPane apCatalogue;
    private ScrollPane paneCatalogue;
    private ScrollPane paneLayout;
    private LayoutControl layoutControl;

    public void setLayoutControl(LayoutControl layoutControl) {
        this.layoutControl = layoutControl;
    }

    @FXML
    void goToCatalogue(MouseEvent event) throws IOException {
        layoutControl.goToCatalogue(null);
        paneLayout.setFocusTraversable(false);
    }

    @FXML
    void goToActu(MouseEvent event) throws IOException {
        layoutControl.goToActu(null);
        paneLayout.setFocusTraversable(false);
    }

    @FXML
    void goToBoutique(MouseEvent event) throws IOException {
        layoutControl.goToBoutique(null);
        paneLayout.setFocusTraversable(false);
    }

}

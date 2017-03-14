package magasin.user;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @author Zaki
 */
public class CatalogueControl {

    private LayoutControl layoutControl;

    public void setLayoutControl(LayoutControl layoutControl) {
        this.layoutControl = layoutControl;
    }

    @FXML
    void changeToGrid(MouseEvent event) throws IOException {
        layoutControl.goToCatalogue(null);
    }

    @FXML
    void changeToList(MouseEvent event) throws IOException {
        layoutControl.changeToList(null);
    }

    @FXML
    void LoadGridPaneElement() throws IOException{

    }



}

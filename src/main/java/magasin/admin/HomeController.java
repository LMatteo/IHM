package magasin.admin;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


/**
 * Created by Meriveri on 13/03/2017.
 */
public class HomeController {

    private AdminLayoutControl adminLayoutControl;

    public void setLayoutControl(AdminLayoutControl layoutControl) {
        this.adminLayoutControl = layoutControl;
    }

    @FXML private Button seeOrder;
    @FXML private Button seeStock;
    @FXML private Label qtOfItems;
    @FXML private Label qtOfLimited;


    @FXML
    void goToLimited(MouseEvent event) throws IOException {
        adminLayoutControl.goToStock(null);
    }

    @FXML
    void setQtOfItems()
    {
        qtOfItems.textProperty().bind(Bindings.format("%d", countItems()));
    }

    @FXML
    void setQtOfLimited()
    {
        qtOfItems.textProperty().bind(Bindings.format("%d", countLimited()));
    }
    private int countItems()
    {
        return (int) (Math.random()*100);
    }

    private int countLimited()
    {
        return (int) (Math.random()*100);
    }
}

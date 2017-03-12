package magasin.admin;


import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @author Zaki
 */
public class OrderControl {

    private ScrollPane paneLayout;
    private AdminLayoutControl adminLayoutControl;

    public void setAdminLayoutControl(AdminLayoutControl adminLayoutControl) {
        this.adminLayoutControl = adminLayoutControl;
    }

    @FXML
    void goToNewOrder(MouseEvent event) throws IOException {
        adminLayoutControl.goToNewOrder(null);
    }

}

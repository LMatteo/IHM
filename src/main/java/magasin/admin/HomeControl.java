package magasin.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Created by Meriveri on 08/03/2017.
 */
public class HomeControl {

    LayoutControl layoutControl;

    @FXML private ScrollPane content ;
    private Button allOrder;
    private Button allLimited;

    void setLayoutControl(LayoutControl lc)
    {
        this.layoutControl = lc;
    }

    @FXML
    void goToOrder(MouseEvent event) throws IOException
    {
        layoutControl.goToOrders();
    }

    @FXML
    void goToStock(MouseEvent event) throws IOException
    {
        layoutControl.goToStocks();
    }

}

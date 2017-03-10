package magasin.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import magasin.admin.HomeControl;

import java.io.IOException;

/**
 * Created by Meriveri on 08/03/2017.
 */
public class LayoutControl {
    @FXML
    protected ScrollPane paneLayout;
    @FXML private Button stocks;
    @FXML private Button orders;
    @FXML private Button stats;
    @FXML private Button stores;
    @FXML private Button about;
    @FXML private Button home;

    private ScrollPane sp;

    Button previous;

    private String green = "#b3d287";
    private String hover = "#7cb131";

    @FXML
    public void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_home.fxml"));
        sp = loader.load();
        HomeControl hc = loader.getController();
        hc.setLayoutControl(this);
        paneLayout.setVvalue(0);
        paneLayout.setContent(sp);
    }

    private void switchButtonStyle(Button b)
    {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + green + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        b.setStyle("-fx-background-color: " + hover + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        previous = b;
    }

    @FXML
    void goToStocks() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Stock.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stocks);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToOrders() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Orders.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stocks);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Stats.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stocks);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToStores() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Map.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stocks);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToAbout() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Info.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(stocks);
        paneLayout.setVvalue(0);
    }

}

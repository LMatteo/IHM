package magasin.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Controller for the admin view's main layout.
 */
public class AdminLayoutControl {

    public static final String bright = "#b3d287";
    public static final String dark = "#7cb131";

    @FXML protected ScrollPane paneLayout;
    @FXML private Button stock;
    @FXML private Button order;
    @FXML private Button stats;
    @FXML private Button boutiques;
    @FXML private Button info;

    private Button previous;
    private ScrollPane sp;

    /**
     * Constructor which loads the homepage directly in the layout when we launch
     * the program
     * @throws IOException
     * @throws URISyntaxException
     */

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Home.fxml"));
        sp = loader.load();
       /*HomeControl homeControl = loader.getController();
        homeControl.setLayoutControl(this);*/
        paneLayout.setVvalue(0);
        paneLayout.setContent(sp);

    }

    /**
     * Switches the style of the top buttons so that the selected screen appears darker.
     *
     * @param current - the last button used
     */
    private void switchButtonStyle(Button current) {
        if (previous != null) {
            previous.setStyle("-fx-background-color: " + bright + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        if(current != null){
            current.setStyle("-fx-background-color: " + dark + "; -fx-border-color: #ffffff; -fx-border-width: 0 0 0 2;");
        }
        previous = current;
    }

    /**
     * Methods which loads views from the layout's buttons
     */

    @FXML
    void goToHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Home.fxml"));
        sp = loader.load();
        paneLayout.setContent(sp);
        paneLayout.setVvalue(0);
        switchButtonStyle(null);
    }

    @FXML
    void goToStock(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Stock.fxml"));
        sp = loader.load();
        OrderControl homeControl = loader.getController();
        homeControl.setAdminLayoutControl(this);
        paneLayout.setContent(sp);
        switchButtonStyle(stock);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToOrder(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Orders.fxml"));
        sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(order);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToStats(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Stats.fxml"));
        sp = loader.load();

        paneLayout.setContent(sp);
        switchButtonStyle(stats);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToBoutiques(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Map.fxml"));
        sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(boutiques);
        paneLayout.setVvalue(0);
    }

    @FXML
    void goToInfo(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_Info.fxml"));
        sp = loader.load();
        paneLayout.setContent(sp);
        switchButtonStyle(info);
        paneLayout.setVvalue(0);
    }

    /**
     * Methods to acces views from other view already loaded in the layout
     */

    @FXML
    void goToNewOrder(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/magasin/admin/Admin_newOrder.fxml"));
        ScrollPane sp = loader.load();
        paneLayout.setContent(sp);
        paneLayout.setVvalue(0);
    }

}

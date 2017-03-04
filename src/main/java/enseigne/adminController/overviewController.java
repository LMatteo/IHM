package enseigne.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class overviewController {

    @FXML
    private VBox paneOld;

    @FXML
    private Button visualizeStore;

    @FXML
    private Button updateStore;

    @FXML
    private PieChart chiffreAffaireChart;

    @FXML
    private PieChart emloyesChart;

    @FXML
    private PieChart produitsChart;

    @FXML
    private BarChart<?, ?> clienteleChart;

    @FXML
    void updateStore(ActionEvent event) {
        System.out.println("salut update");
    }

    @FXML
    void visualizeStore(ActionEvent event) {
        System.out.println("salut visu");

    }

}

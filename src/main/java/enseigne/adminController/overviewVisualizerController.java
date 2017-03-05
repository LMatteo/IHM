package enseigne.adminController;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class overviewVisualizerController {

    @FXML
    private ComboBox<String> choiceBox;

    @FXML
    private Label centreLabel;

    @FXML
    private Label chiffreAffaireLabel;

    @FXML
    private Label employesLabel;

    @FXML
    private PieChart clienteleChart;

    @FXML
    private BarChart<?, ?> horairesChart;

    @FXML
    private VBox mainBox;

    private MagFilter filter;

    public void update() throws IOException {
        filter = new MagFilter();
        List<Magasin> magasins = filter.toDisplay();
        List<String> choices = new ArrayList<>();
        for (Magasin m : magasins) {
            choices.add(m.getCentre());
        }

        choiceBox.getItems().addAll(choices);
        choiceBox.setPromptText("...");

        mainBox.setVisible(false);


    }

    @FXML
    void displaySelected(ActionEvent event) {
        mainBox.setVisible(true);
        Magasin m = ReadConst.getStoreByCenter(choiceBox.getSelectionModel().getSelectedItem());
        centreLabel.setText(m.getCentre());
        chiffreAffaireLabel.setText(String.valueOf(m.getChiffreAffaire()));
        employesLabel.setText(String.valueOf(m.getNbEmpl()));
    }

}
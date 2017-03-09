package enseigne.adminController;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
    private BarChart<String, Integer> horairesChart;

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
    void closeWindow() {
        mainBox.getScene().getWindow().hide();
    }

    @FXML
    void displaySelected(ActionEvent event) {
        mainBox.setVisible(true);
        Magasin m = ReadConst.getStoreByCenter(choiceBox.getSelectionModel().getSelectedItem());
        centreLabel.setText(m.getCentre());
        chiffreAffaireLabel.setText(String.valueOf(m.getChiffreAffaire()));
        employesLabel.setText(String.valueOf(m.getNbEmpl()));
        overviewController o = new overviewController();
        clienteleChart.setData(getClienteleList(m));
        horairesChart.setData(getHorairesList(m));
    }

    private ObservableList<PieChart.Data> getClienteleList(Magasin m) {
        List<PieChart.Data> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String str = Integer.toString(i * 15) + " - " + Integer.toString((i + 1) * 15 - 1) + " ans";
            if (i == 4) str = Integer.toString(i * 15) + " ans et plus";
            PieChart.Data data = new PieChart.Data(str, m.getAge().get(i));
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    private ObservableList<XYChart.Series<String, Integer>> getHorairesList(Magasin m) {
        ObservableList<XYChart.Series<String, Integer>> list = FXCollections.observableArrayList();
        XYChart.Series series = new XYChart.Series();
        series.setName(m.getCentre());
        for (int i = 0; i < 5; i++) {
            String title = Integer.toString((i*2)+8)+"h " + Integer.toString((i*2)+10) + "h";
            series.getData().add(new XYChart.Data<String, Integer>(title, m.getPointe().get(i)));
        }
        list.add(series);

        return list;
    }

}
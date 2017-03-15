package enseigne.adminController.overview;

import enseigne.modele.magasin.Magasin;
import enseigne.modele.MagFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class overviewController {

    @FXML
    private VBox paneOld;

    @FXML
    private Button visualizeStore;

    @FXML
    private Button updateStore;

    @FXML
    private Label nbMags;

    @FXML
    private Label ChiffreAffaireTotal;

    @FXML
    private Label nbEmployesTotal;

    @FXML
    private PieChart chiffreAffaireChart;

    @FXML
    private PieChart employesChart;

    @FXML
    private BarChart<String, Integer> clienteleChart;

    @FXML
    private VBox pane;

    @FXML
    private Label employesTitle;

    @FXML
    private Label chiffreAffairesTitle;

    @FXML
    private Label clientsTitle;



    private MagFilter filter;



    public void update() throws IOException {
        filter = new MagFilter();
        List<Magasin> magasins = filter.toDisplay();
        nbMags.setText(String.valueOf(magasins.size()));
        ChiffreAffaireTotal.setText(getTotalChiffreAffaire(magasins)+" €");
        nbEmployesTotal.setText(String.valueOf(getTotalEmployes(magasins)));
        chiffreAffaireChart.setData(getChiffreAffaireDatas(magasins));
        chiffreAffairesTitle.setText("Chiffre d'affaires annuel (total : " + getTotalChiffreAffaire(magasins) + " €)");
        employesChart.setData(getEmployesDatas(magasins));
        employesTitle.setText("Effectifs (total : " + getTotalEmployes(magasins) + " employés)");
        clienteleChart.setData(getClientele(magasins));
        clienteleChart.getXAxis().setLabel("Magasins");
        clienteleChart.getYAxis().setLabel("Nombre de clients");
    }

    private ObservableList<PieChart.Data> getChiffreAffaireDatas(List<Magasin> magasins) {
        List<PieChart.Data> datas = new ArrayList<>();
        for (Magasin m : magasins) {
            PieChart.Data data = new PieChart.Data(m.getCentre(), m.getChiffreAffaire());
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    private ObservableList<PieChart.Data> getEmployesDatas(List<Magasin> magasins) {
        List<PieChart.Data> datas = new ArrayList<>();
        for (Magasin m : magasins) {
            PieChart.Data data = new PieChart.Data(m.getCentre(), m.getNbEmpl());
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    private ObservableList<XYChart.Series<String,Integer>> getClientele(List<Magasin> magasins) {
        ObservableList<XYChart.Series<String,Integer>> list = FXCollections.observableArrayList();
        for(Magasin m : magasins){
            XYChart.Series series = new XYChart.Series();
            series.setName(m.getCentre());
            for(int i=0;i<5;i++){
                String title = Integer.toString(i*15)+" - "+Integer.toString((i+1)*15-1)+" ans";
                if(i==4) title = Integer.toString(i*15)+" ans et plus";
                series.getData().add(new XYChart.Data<String,Integer>(title,m.getAge().get(i)));
            }
            list.add(series);
        }
        return list;
    }

    @FXML
    void updateStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/updaterOverview.fxml"));
        Parent rootNode = loader.load();
        overviewUpdaterController ctrl = loader.getController();
        ctrl.update();
        ctrl.setOriginController(this);
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Modification des données");
        stage.show();
    }

    @FXML
    void visualizeStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enseigne/admin/visualizerOverview.fxml"));
        Parent rootNode = loader.load();
        overviewVisualizerController ctrl = loader.getController();
        ctrl.update();
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Données statistiques");
        stage.show();

    }

    private int getTotalChiffreAffaire(List<Magasin> magasins) {
        int sum = 0;
        for (Magasin m : magasins) {
            sum += m.getChiffreAffaire();
        }
        return sum;
    }

    private int getTotalEmployes(List<Magasin> magasins) {
        int sum = 0;
        for (Magasin m : magasins) {
            sum += m.getNbEmpl();
        }
        return sum;
    }

    private int getTotalProduitsRendus(List<Magasin> magasins) {
        int sum = 0;
        for (Magasin m : magasins) {
            sum += m.getRendu();
        }
        return sum;
    }


}

package enseigne.adminController;

import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.apache.commons.lang.math.RandomUtils;

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
    private Button updateBtn;

    @FXML
    private PieChart chiffreAffaireChart;

    @FXML
    private PieChart employesChart;

    @FXML
    private PieChart produitsChart;

    @FXML
    private BarChart<?, ?> clienteleChart;

    @FXML
    private VBox pane;

    @FXML
    private Label employesTitle;

    @FXML
    private Label chiffreAffairesTitle;

    @FXML
    private Label clientsTitle;

    @FXML
    private Label produitsTitle;


    private MagFilter filter;


    @FXML
    public void update(ActionEvent event) throws IOException {
        filter = new MagFilter();
        List<Magasin> magasins = filter.toDisplay();
        chiffreAffaireChart.setData(getChiffreAffaireDatas(magasins));
        chiffreAffairesTitle.setText("Chiffre d'affaires (total : "+getTotalChiffreAffaire(magasins)+" €)");
        employesChart.setData(getEmployesDatas(magasins));
        employesTitle.setText("Effectifs (total : "+getTotalEmployes(magasins)+" employés)");
        produitsChart.setData(getProduitsRenduDatas(magasins));
        produitsTitle.setText("Produits renvoyés (total : "+getTotalProduitsRendus(magasins)+")");
    }

    private ObservableList<PieChart.Data> getChiffreAffaireDatas(List<Magasin> magasins){
        List<PieChart.Data> datas= new ArrayList<>();
        for(Magasin m : magasins){
            m.setChiffreAffaire(RandomUtils.nextInt());
            PieChart.Data data = new PieChart.Data(m.getCentre(),m.getChiffreAffaire());
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    private ObservableList<PieChart.Data> getEmployesDatas(List<Magasin> magasins){
        List<PieChart.Data> datas= new ArrayList<>();
        for(Magasin m : magasins){
            m.setNbEmpl(RandomUtils.nextInt());
            PieChart.Data data = new PieChart.Data(m.getCentre(),m.getNbEmpl());
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    private ObservableList<PieChart.Data> getProduitsRenduDatas(List<Magasin> magasins){
        List<PieChart.Data> datas= new ArrayList<>();
        for(Magasin m : magasins){
            m.setRendu(RandomUtils.nextInt());
            PieChart.Data data = new PieChart.Data( m.getCentre(),m.getRendu());
            datas.add(data);
        }
        return FXCollections.observableList(datas);
    }

    @FXML
    void updateStore(ActionEvent event) {
    }

    @FXML
    void visualizeStore(ActionEvent event) {

    }

    private int getTotalChiffreAffaire(List<Magasin> magasins){
        int sum = 0;
        for(Magasin m : magasins){
            sum += m.getChiffreAffaire();
        }
        return sum;
    }
    private int getTotalEmployes(List<Magasin> magasins){
        int sum = 0;
        for(Magasin m : magasins){
            sum += m.getNbEmpl();
        }
        return sum;
    }

    private int getTotalProduitsRendus(List<Magasin> magasins){
        int sum = 0;
        for(Magasin m : magasins){
            sum += m.getRendu();
        }
        return sum;
    }


}

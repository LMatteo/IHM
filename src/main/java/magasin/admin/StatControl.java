package magasin.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.input.MouseEvent;
import magasin.modele.charts.Charts;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Meriveri on 14/03/2017.
 */
public class StatControl
{

    @FXML private PieChart pie;
    @FXML private BarChart<String, Double> perhour;
    @FXML private LineChart<String, Double> years;
    @FXML private LineChart<String, Double> months;
    @FXML private LineChart<String, Double> weeks;

    Charts chart;
    List<String> sellers;
    HashMap<String, Integer> sellersSales;

    @FXML
    protected void initialize() throws IOException {
/*        chart = new Charts();
        sellers = chart.getSellers();
        sellersSales = chart.getSellersSales();*/
        fillPieChart();
        fillSellPerHours();
        fillyears();
        fillmonths();
        fillweeks();

    }


    private ObservableList<PieChart.Data> dataSetter() {
        ObservableList<PieChart.Data> list = FXCollections.observableList(new ArrayList<PieChart.Data>());

        for (int i = 0; i < sellers.size(); i++) {
            list.add(new PieChart.Data(sellers.get(i), sellersSales.get(sellers.get(i))));
        }
        return list;
    }

    @FXML
    private void fillPieChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Amy Pond", 92),
                        new PieChart.Data("Dean Wintchester", 82),
                        new PieChart.Data("Ned Stark", 44),
                        new PieChart.Data("Jim Moriarty", 87)
                );

        pie.setTitle("Répartition des ventes");
        pie.setData(pieChartData);
    }

    @FXML
    private void fillSellPerHours()
    {

            ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();
            XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
            XYChart.Series<String, Double> bSeries = new XYChart.Series<String, Double>();
            aSeries.setName("semaine");
            bSeries.setName("week-end");

            aSeries.getData().add(new XYChart.Data("8-10", 12));
            bSeries.getData().add(new XYChart.Data("8-10", 15));

            aSeries.getData().add(new XYChart.Data("10-12", 14));
            bSeries.getData().add(new XYChart.Data("10-12", 19));

            aSeries.getData().add(new XYChart.Data("12-14", 10));
            bSeries.getData().add(new XYChart.Data("12-14", 16));

            aSeries.getData().add(new XYChart.Data("14-16", 19));
            bSeries.getData().add(new XYChart.Data("14-16", 25));

            aSeries.getData().add(new XYChart.Data("16-18", 14));
            bSeries.getData().add(new XYChart.Data("16-18", 19));


            graph.addAll(aSeries, bSeries);
            perhour.setTitle("Ventes par tranches horaires");
            perhour.setData(graph);

    }

    @FXML
    public void fillyears()
    {
        ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        aSeries.setName("Année");



        aSeries.getData().add(new XYChart.Data("2010", 3000));
        aSeries.getData().add(new XYChart.Data("2011", 3500));
        aSeries.getData().add(new XYChart.Data("2012", 3750));
        aSeries.getData().add(new XYChart.Data("2013", 4000));
        aSeries.getData().add(new XYChart.Data("2014", 4300));
        aSeries.getData().add(new XYChart.Data("2015", 4300));
        aSeries.getData().add(new XYChart.Data("2016", 4800));
        aSeries.getData().add(new XYChart.Data("2017", 3000));

        graph.addAll(aSeries);
        years.setData(graph);

    }

    @FXML
    public void fillweeks()
    {
        ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        aSeries.setName("Semaine");

        aSeries.getData().add(new XYChart.Data("Lundi", 20));
        aSeries.getData().add(new XYChart.Data("Mardi", 25));
        aSeries.getData().add(new XYChart.Data("Mercredi", 27));
        aSeries.getData().add(new XYChart.Data("Jeudi", 26));
        aSeries.getData().add(new XYChart.Data("Vendredi", 29));
        aSeries.getData().add(new XYChart.Data("Samedi", 40));

        graph.addAll(aSeries);
        weeks.setData(graph);

    }


    @FXML
    public void fillmonths()
    {
        ObservableList<XYChart.Series<String, Double>> graphic = FXCollections.observableArrayList();
        XYChart.Series<String, Double> bSeries = new XYChart.Series<String, Double>();
        bSeries.setName("Mois");

        bSeries.getData().add(new XYChart.Data("Janv.", 500));
        bSeries.getData().add(new XYChart.Data("Fév.", 600));
        bSeries.getData().add(new XYChart.Data("Mar.", 700));
        bSeries.getData().add(new XYChart.Data("Avril.", 650));
        bSeries.getData().add(new XYChart.Data("Mai.", 750));
        bSeries.getData().add(new XYChart.Data("Juin.", 750));
        bSeries.getData().add(new XYChart.Data("Juil.", 950));
        bSeries.getData().add(new XYChart.Data("Aou.", 990));
        bSeries.getData().add(new XYChart.Data("Sep.", 890));
        bSeries.getData().add(new XYChart.Data("Oct.", 790));
        bSeries.getData().add(new XYChart.Data("Nov.", 750));
        bSeries.getData().add(new XYChart.Data("Déc.", 1050));


        graphic.addAll(bSeries);
        months.setData(graphic);

    }


}

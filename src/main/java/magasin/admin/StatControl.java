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
import java.util.*;

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
        chart = new Charts();
        sellers = chart.getSellers();
        sellersSales = chart.getSellersSales();
        fillPieChart();
        fillSellPerHours();
        fillyears();
        fillmonths();
        fillweeks();

    }


    private ObservableList<PieChart.Data> pieDataSetter() {
        ObservableList<PieChart.Data> list = FXCollections.observableList(new ArrayList<PieChart.Data>());

        for (int i = 0; i < sellers.size(); i++) {
            list.add(new PieChart.Data(sellers.get(i), sellersSales.get(sellers.get(i))));
        }
        return list;
    }

    @FXML
    private void fillPieChart() {
/*        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Amy Pond", 92),
                        new PieChart.Data("Dean Wintchester", 82),
                        new PieChart.Data("Ned Stark", 44),
                        new PieChart.Data("Jim Moriarty", 87)
                );*/

        pie.setTitle("Répartition des ventes");
        pie.setLegendVisible(false);
        pie.setData(pieDataSetter());
    }


    private ObservableList<XYChart.Series<String, Double>> hourDataSetter()
    {
        ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();

        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> bSeries = new XYChart.Series<String, Double>();
        aSeries.setName("semaine");
        bSeries.setName("week-end");

        int var8, var10, var12, var14, var16;
        var8 = 0;
        var10 = 0;
        var12 = 0;
        var14 = 0;
        var16 = 0;
        for(int i = 0 ; i < chart.getSales().size() ; i++)
        {
                switch(chart.getSales().get(i).getString("Heure"))
                {
                    case "08-10":
                        var8++;
                        break;
                    case "10-12":
                        var10++;
                        break;
                    case "12-14":
                        var12++;
                        break;
                    case "14-16":
                        var14++;
                        break;
                    case "16-18":
                        var16++;
                        break;
                    default:
                        break;
                }
            }

        aSeries.getData().add(new XYChart.Data("8-10", var8));
        bSeries.getData().add(new XYChart.Data("8-10", var8*1.2));

        aSeries.getData().add(new XYChart.Data("10-12", var10));
        bSeries.getData().add(new XYChart.Data("10-12", var10*1.1));

        aSeries.getData().add(new XYChart.Data("12-14", var12));
        bSeries.getData().add(new XYChart.Data("12-14", var12*1.13));

        aSeries.getData().add(new XYChart.Data("14-16", var14));
        bSeries.getData().add(new XYChart.Data("14-16", var14*1.3));

        aSeries.getData().add(new XYChart.Data("16-18", var16));
        bSeries.getData().add(new XYChart.Data("16-18", var16*1.21));


        graph.addAll(aSeries, bSeries);
        return graph;


    }

    @FXML
    private void fillSellPerHours()
    {


            perhour.setTitle("Ventes par tranches horaires");
            perhour.setData(hourDataSetter());

    }


    private ObservableList<XYChart.Series<String, Double>> yearSetter() throws IOException {

        ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        aSeries.setName("Année");
        Calendar c = new GregorianCalendar();
        c.add(Calendar.YEAR, -1);
        for(int i = 2013; i <= 2016; i++)
        {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), chart.getYear(i)));
        }

        graph.addAll(aSeries);

        return graph;
    }

    @FXML
    public void fillyears() throws IOException {
        years.setData(yearSetter());

    }

    private String numberToDay(int j)
    {
        switch (j)
        {
            case 2:
                return "Lundi";
            case 3:
                return "Mardi";
            case 4:
                return "Mercredi";
            case 5:
                return "Jeudi";
            case 6:
                return "Vendredi";
            case 7:
                return "Samedi";
        }
        return null;
    }

    private ObservableList<XYChart.Series<String, Double>> weekSetter() throws IOException {
        ObservableList<XYChart.Series<String, Double>> graph = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        aSeries.setName("Semaine");
        Calendar c = new GregorianCalendar();
        for(int i = 2; i <= 7 ; i++)
            aSeries.getData().add(new XYChart.Data(numberToDay(i), chart.getWeek(i)));

        graph.addAll(aSeries);
        return graph;
    }

    @FXML
    public void fillweeks() throws IOException {
        weeks.setData(weekSetter());

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

package enseigne;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ChartTests extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root);
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        Magasin m1 = new Magasin(ReadConst.storePath+"salut.fr.json");
        Magasin m2 = new Magasin(ReadConst.storePath+"salut.fr.json");
        Magasin m3 = new Magasin(ReadConst.storePath+"salut.fr.json");

        m1.setChiffreAffaire(20000);
        m2.setChiffreAffaire(35500);
        m3.setChiffreAffaire(50000);


        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(m1.getCentre(),m1.getChiffreAffaire()),
                        new PieChart.Data(m2.getCentre(),m2.getChiffreAffaire()),
                        new PieChart.Data(m3.getCentre(),m3.getChiffreAffaire()));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        final Label caption = new Label("");
        caption.setTextFill(Color.RED);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,
                    e -> {
                        double total = 0;
                        for (PieChart.Data d : chart.getData()) {
                            total += d.getPieValue();
                        }
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        String text = String.format("%.1f%%", 100 * data.getPieValue() / total);
                        caption.setText(text);
                    }
            );
        }

        root.getChildren().addAll(chart, caption);
        stage.setScene(scene);
        stage.show();
    }
}

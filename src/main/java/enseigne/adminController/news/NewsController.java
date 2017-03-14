package enseigne.adminController.news;

import enseigne.ToNode;
import enseigne.modele.ReadConst;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class NewsController {

    @FXML
    private VBox displayPane;

    @FXML
    public void initialize() throws IOException {
        File folder = new File(ReadConst.newsPath);
        File[] listOfFiles = folder.listFiles();

        for (File f : listOfFiles) {
            displayPane.getChildren().add(ToNode.news(new Image(f.toURI().toString())));
        }
    }
}


package centre.controller;

import centre.News;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controller for the sorting order selector screen.
 */
public class NewsSelectorController {

    @FXML
    private VBox list;

    private AdminNewsController controller;

    public void bindTo(AdminNewsController controller) {
        this.controller = controller;
    }


    public void initializeContents(List<News> newsList) throws IOException {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        int i = 1;
        for (News n : newsList) {
            Label label = new Label(n.getName() + " - " + dateFormat.format(new Date(n.getDate() * 1000)));
            label.setPrefWidth(600);
            label.setAlignment(Pos.CENTER);
            label.setCursor(Cursor.HAND);
            if (i % 2 == 0) {
                label.setStyle("-fx-font: 22 System;");
            } else {
                label.setStyle("-fx-font: 22 System; -fx-background-color: #dcdcdc;");
            }
            ++i;
            list.getChildren().add(label);
        }
    }
}


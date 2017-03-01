package centre.controller;

import centre.SortOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Controller for the sorting order selector screen.
 */
public class SortSelectorController {

    @FXML
    private VBox sortBox;

    private EditSortController parent;
    private SortOrder selection;
    private Label selectedLabel;

    /**
     * Binds this controller to an edit sort controller to return later what sorting
     * order was picked.
     *
     * @param controller - the parent edit sort controller
     */
    public void bindTo(EditSortController controller) {
        parent = controller;
    }

    /**
     * Initializes the list of sorting orders to fill the selector box.
     */
    @FXML
    public void initialize() throws IOException {
        File[] sortFolder = new File("data/centre/sort/").listFiles();
        if (sortFolder == null) {
            return;
        }
        for (int i = 0; i < sortFolder.length; i++) {
            File file = sortFolder[i];
            SortOrder order = new SortOrder(file);
            Label label = new Label(order.getName());
            if (i % 2 == 0) {
                label.setStyle("-fx-font: 22 System;");
            } else {
                label.setStyle("-fx-font: 22 System; -fx-background-color: #dcdcdc;");
            }
            label.setPrefSize(561, 48);
            label.setAlignment(Pos.CENTER);
            label.setOnMouseClicked(event -> {
                selection = order;
                label.setStyle("-fx-font: 22 System; -fx-background-color: #add8e6");
                if (selectedLabel != null && selectedLabel != label) {
                    int index = sortBox.getChildren().indexOf(selectedLabel);
                    if (index % 2 == 0) {
                        selectedLabel.setStyle("-fx-font: 22 System;");
                    } else {
                        selectedLabel.setStyle("-fx-font: 22 System; -fx-background-color: #dcdcdc;");
                    }
                }
                selectedLabel = label;
            });
            sortBox.getChildren().add(label);
        }
    }

    /**
     * If a sorting order is selected, closes the window and loads its information in the
     * sorting editor screen.
     *
     * @param event - the action event of this action
     * @throws IOException - if failing to load the sorting order data
     */
    @FXML
    void confirmSort(ActionEvent event) throws IOException {
        if (selection != null) {
            parent.load(selection);
            Stage stage = (Stage) sortBox.getScene().getWindow();
            stage.close();
        }
    }

}

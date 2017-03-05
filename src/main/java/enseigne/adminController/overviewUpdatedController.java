package enseigne.adminController;

import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class overviewUpdatedController {

    @FXML
    private ComboBox<String> choiceBox;

    @FXML
    private VBox mainBox;

    private MagFilter filter;

    @FXML
    void displaySelected(ActionEvent event) {
        mainBox.setVisible(true);
    }

    public void update() throws IOException {
        filter = new MagFilter();
        List<Magasin> magasins = filter.toDisplay();
        List<String> choices = new ArrayList<>();
        for (Magasin m : magasins) {
            choices.add(m.getCentre());
        }
        choiceBox.setPromptText("...");
        choiceBox.getItems().addAll(choices);
        mainBox.setVisible(false);
    }

}

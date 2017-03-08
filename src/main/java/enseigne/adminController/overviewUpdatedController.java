package enseigne.adminController;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.MagFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class overviewUpdatedController {

    @FXML
    private ComboBox<String> choiceBox;

    @FXML
    private Label minus0;

    @FXML
    private TextField chiffreAffaireLabel;

    @FXML
    private TextField employesLabel;

    @FXML
    private TextField age0;

    @FXML
    private TextField age15;

    @FXML
    private TextField age30;

    @FXML
    private TextField age45;

    @FXML
    private TextField age60;

    @FXML
    private TextField horaire8;

    @FXML
    private TextField horaire10;

    @FXML
    private TextField horaire12;

    @FXML
    private TextField horaire14;

    @FXML
    private TextField horaire16;


    @FXML
    private VBox mainBox;

    private MagFilter filter;
    private Magasin selectedMagasin;

    @FXML
    void displaySelected(ActionEvent event) {
        mainBox.setVisible(true);
        selectedMagasin = ReadConst.getStoreByCenter(choiceBox.getSelectionModel().getSelectedItem());
        chiffreAffaireLabel.setText(String.valueOf(selectedMagasin.getChiffreAffaire()));
        employesLabel.setText(String.valueOf(selectedMagasin.getNbEmpl()));
        horaire8.setText(String.valueOf(selectedMagasin.getPointe().get(0)));

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

    @FXML
    void validate(ActionEvent event) throws IOException {
        selectedMagasin.setChiffreAffaire(Integer.parseInt(chiffreAffaireLabel.getText()));
        selectedMagasin.setNbEmpl(Integer.parseInt(employesLabel.getText()));
        List<Integer> horaires = new ArrayList<>();
        horaires.add(Integer.parseInt(horaire8.getText()));
        selectedMagasin.write();
        mainBox.getScene().getWindow().hide();
    }

    @FXML
    void minusHoraire0(ActionEvent event) {

    }

    @FXML
    void minusHoraire10(ActionEvent event) {

    }

    @FXML
    void minusHoraire12(ActionEvent event) {

    }

    @FXML
    void minusHoraire14(ActionEvent event) {

    }

    @FXML
    void minusHoraire16(ActionEvent event) {

    }

    @FXML
    void plusHoraire10(ActionEvent event) {

    }

    @FXML
    void plusHoraire12(ActionEvent event) {

    }

    @FXML
    void plusHoraire14(ActionEvent event) {

    }

    @FXML
    void plusHoraire16(ActionEvent event) {

    }

    @FXML
    void plusHoraire8(ActionEvent event) {

    }



}

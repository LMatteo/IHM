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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class overviewUpdaterController {

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

    private overviewController originController;


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
        horaire10.setText(String.valueOf(selectedMagasin.getPointe().get(1)));
        horaire12.setText(String.valueOf(selectedMagasin.getPointe().get(2)));
        horaire14.setText(String.valueOf(selectedMagasin.getPointe().get(3)));
        horaire16.setText(String.valueOf(selectedMagasin.getPointe().get(4)));
        age0.setText(String.valueOf(selectedMagasin.getAge().get(0)));
        age15.setText(String.valueOf(selectedMagasin.getAge().get(1)));
        age30.setText(String.valueOf(selectedMagasin.getAge().get(2)));
        age45.setText(String.valueOf(selectedMagasin.getAge().get(3)));
        age60.setText(String.valueOf(selectedMagasin.getAge().get(4)));

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

        Map<Integer, Integer> mapHoraires = new HashMap<>();
        mapHoraires.put(0, Integer.valueOf(horaire8.getText()));
        mapHoraires.put(1, Integer.valueOf(horaire10.getText()));
        mapHoraires.put(2, Integer.valueOf(horaire12.getText()));
        mapHoraires.put(3, Integer.valueOf(horaire14.getText()));
        mapHoraires.put(4, Integer.valueOf(horaire16.getText()));
        selectedMagasin.setPointe(mapHoraires);

        Map<Integer, Integer> mapClientele = new HashMap<>();
        mapClientele.put(0, Integer.valueOf(age0.getText()));
        mapClientele.put(1, Integer.valueOf(age15.getText()));
        mapClientele.put(2, Integer.valueOf(age30.getText()));
        mapClientele.put(3, Integer.valueOf(age45.getText()));
        mapClientele.put(4, Integer.valueOf(age60.getText()));
        selectedMagasin.setAge(mapClientele);
        selectedMagasin.write();
        mainBox.getScene().getWindow().hide();
        originController.update();
    }

    @FXML
    void minusHoraire0(ActionEvent event) {
        horaire8.setText(String.valueOf(Integer.parseInt(horaire8.getText()) - 1));

    }

    @FXML
    void minusHoraire10(ActionEvent event) {
        horaire10.setText(String.valueOf(Integer.parseInt(horaire10.getText()) - 1));

    }

    @FXML
    void minusHoraire12(ActionEvent event) {
        horaire12.setText(String.valueOf(Integer.parseInt(horaire12.getText()) - 1));

    }

    @FXML
    void minusHoraire14(ActionEvent event) {
        horaire14.setText(String.valueOf(Integer.parseInt(horaire14.getText()) - 1));

    }

    @FXML
    void minusHoraire16(ActionEvent event) {
        horaire16.setText(String.valueOf(Integer.parseInt(horaire16.getText()) - 1));
    }

    @FXML
    void plusHoraire10(ActionEvent event) {
        horaire10.setText(String.valueOf(Integer.parseInt(horaire10.getText()) + 1));
    }

    @FXML
    void plusHoraire12(ActionEvent event) {
        horaire12.setText(String.valueOf(Integer.parseInt(horaire12.getText()) + 1));
    }

    @FXML
    void plusHoraire14(ActionEvent event) {
        horaire14.setText(String.valueOf(Integer.parseInt(horaire14.getText()) + 1));
    }

    @FXML
    void plusHoraire16(ActionEvent event) {
        horaire16.setText(String.valueOf(Integer.parseInt(horaire16.getText()) + 1));
    }

    @FXML
    void plusHoraire8(ActionEvent event) {
        horaire8.setText(String.valueOf(Integer.parseInt(horaire8.getText()) + 1));
    }

    public void setOriginController(overviewController o) {
        this.originController = o;
    }

    @FXML
    void client0minus(ActionEvent event) {
        age0.setText(String.valueOf(Integer.parseInt(age0.getText()) - 1));
    }

    @FXML
    void client0plus(ActionEvent event) {
        age0.setText(String.valueOf(Integer.parseInt(age0.getText()) + 1));
    }

    @FXML
    void client1minus(ActionEvent event) {
        age15.setText(String.valueOf(Integer.parseInt(age15.getText()) - 1));
    }

    @FXML
    void client1plus(ActionEvent event) {
        age15.setText(String.valueOf(Integer.parseInt(age15.getText()) + 1));
    }

    @FXML
    void client2minus(ActionEvent event) {
        age30.setText(String.valueOf(Integer.parseInt(age30.getText()) - 1));
    }

    @FXML
    void client2plus(ActionEvent event) {
        age30.setText(String.valueOf(Integer.parseInt(age30.getText()) + 1));
    }

    @FXML
    void client3minus(ActionEvent event) {
        age45.setText(String.valueOf(Integer.parseInt(age45.getText()) - 1));
    }

    @FXML
    void client3plus(ActionEvent event) {
        age45.setText(String.valueOf(Integer.parseInt(age45.getText()) + 1));
    }

    @FXML
    void client4minus(ActionEvent event) {
        age60.setText(String.valueOf(Integer.parseInt(age60.getText()) - 1));
    }

    @FXML
    void client4plus(ActionEvent event) {
        age60.setText(String.valueOf(Integer.parseInt(age60.getText()) + 1));
    }


}

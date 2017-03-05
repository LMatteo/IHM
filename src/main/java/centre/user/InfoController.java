package centre.user;

import centre.constant.ButtonLabels;
import centre.constant.CentrePaths;
import centre.model.Informations;
import centre.model.Store;
import centre.model.StoreList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the info screen.
 */
public class InfoController implements LanguageSwitcher {

    private StoreList loadedStores;
    private Informations infos;
    private boolean french = true;
    private List<Label> lines;

    @FXML private GridPane grid;
    @FXML private Label line1;
    @FXML private Label line2;
    @FXML private Label line3;
    @FXML private Label line4;
    @FXML private ImageView mapPic;
    @FXML private Label legend;

    /**
     * Initializes the store data required to fill the map indications.
     *
     * @param loadedStores - the list of loaded stores
     * @throws IOException - if failing to read the informations
     */
    public void initializeContent(StoreList loadedStores) throws IOException {
        this.loadedStores = loadedStores;
        mapPic.setImage(new Image(CentrePaths.getMapPath()));
        initGrid();
        infos = new Informations();
        lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        initText();
    }

    /**
     * Initializes the map indications : displays each store map id and places it
     * in the correct location in the gridPane containing the map legend.
     */
    private void initGrid() {
        for (Store store : loadedStores.getList()) {
            int id = store.getMapId();
            Label label = new Label(Integer.toString(id + 1) + ". " + store.getName());
            label.setPrefSize(141, 54);
            label.setStyle("-fx-font: 15 System;");
            GridPane.setColumnIndex(label, id / 6);
            GridPane.setRowIndex(label, id % 6);
            grid.getChildren().add(label);
        }
    }

    /**
     * Initializes the text of the information screen.
     */
    private void initText() {
        List<String> text;
        if (french) {
            legend.setText(ButtonLabels.LEGEND_FR);
            text = infos.getFrench();
        } else {
            legend.setText(ButtonLabels.LEGEND_EN);
            text = infos.getEnglish();
        }
        for (int i = 0; i < text.size(); i++) {
            lines.get(i).setText(text.get(i));
        }
    }

    /**
     * Switches the language of the interface back and forth between french and english.
     */
    @Override
    public void switchLanguage() {
        french = !french;
        initText();
    }

}


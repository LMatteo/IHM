package centre.admin.sort;

import centre.model.SortOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Controller class for the window to create new sorting order.
 */
public class SortTitleController {

    @FXML private TextField titleText;
    @FXML private TextField titleTextEnglish;

    private EditSortController parent;

    /**
     * Binds this controller to its parent, to be able to return the new sorting
     * order name later.
     *
     * @param controller - the controller that needs to receive the name later
     */
    public void bindTo(EditSortController controller) {
        parent = controller;
    }

    /**
     * Creates a new sorting order and loads its data in the sorting editor screen.
     * Closes the window.
     * If the text field is empty, does nothing.
     *
     * @param event - the action event of this action
     * @throws IOException        - if failing to load the sort order data
     * @throws URISyntaxException - if failing to reload the store logos
     */
    @FXML
    void create(ActionEvent event) throws IOException, URISyntaxException {
        if (!titleText.getText().equals("") && !titleTextEnglish.getText().equals("")) {
            SortOrder order = new SortOrder(titleText.getText(), titleTextEnglish.getText());
            parent.load(order);
            Stage stage = (Stage) titleText.getScene().getWindow();
            stage.close();
        }
    }

}

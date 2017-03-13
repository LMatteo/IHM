package centre.user;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for a suggestion in the research field of the store screen.
 */
public class SearchItemController {

    private TextField searchBar;

    @FXML
    private Label label;

    /**
     * Event called when clicking on the suggestion.
     *
     * @param event - the mouse event of this action
     */
    @FXML
    void clickLabel(MouseEvent event) {
        searchBar.setText(label.getText());
    }

    /**
     * Sets the name of the suggestion.
     *
     * @param name - the name of the suggestion.
     */
    public void initializeContent(String name, TextField searchBar) {
        label.setText(name);
        this.searchBar = searchBar;
    }

}

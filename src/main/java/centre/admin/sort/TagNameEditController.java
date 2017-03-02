package centre.admin.sort;

import centre.model.Tag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the tag name edit window.
 */
public class TagNameEditController {

    @FXML private TextField tagFrench;
    @FXML private TextField tagEnglish;

    private EditSortController parent;

    /**
     * Binds this window to a specific controller to notify it once the modification has
     * been done.
     *
     * @param controller - the controller receiving the new tag name later
     */
    public void bindTo(EditSortController controller) {
        parent = controller;
    }

    /**
     * Fills the text fields with the tag current names.
     *
     * @param tag - the tag to load in the editor window
     */
    public void initializeContent(Tag tag) {
        tagFrench.setText(tag.getFrench());
        tagEnglish.setText(tag.getEnglish());
    }

    /**
     * Closes the window and confirms the new tag name if the fields have been completed.
     *
     * @param event - the event of this action
     */
    @FXML
    void confirm(ActionEvent event) {
        if (!tagFrench.getText().equals("") && !tagEnglish.getText().equals("")) {
            parent.updateCurrentTag(new Tag(tagFrench.getText(), tagEnglish.getText()));
            Stage stage = (Stage) tagEnglish.getScene().getWindow();
            stage.close();
        }
    }

}

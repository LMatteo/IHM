package centre.constant;

import javafx.scene.control.Alert.AlertType;

/**
 * Static class used to display an alert message.
 */
public class AlertMessage {

    /**
     * Displays an alert message to the user.
     *
     * @param type    - the type of the alert
     * @param title   - the title of the alert
     * @param content - the content of the alert
     */
    public static void alert(AlertType type, String title, String content) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

}

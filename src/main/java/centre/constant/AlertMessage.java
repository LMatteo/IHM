package centre.constant;

import javafx.scene.control.Alert.AlertType;

public class AlertMessage {

    public static void alert(AlertType type, String title, String content) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

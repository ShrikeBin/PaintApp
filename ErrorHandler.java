import java.util.logging.Level;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @brief Utility class for displaying error messages using JavaFX Alert dialogs.
 */
public class ErrorHandler {

    /**
     * @brief Private constructor to prevent instantiation of ErrorHandler objects.
     */
    private ErrorHandler() {
        throw new InstantiationError("ErrorHandler is a static class");
    }

    /**
     * @brief Displays an error message in an Alert dialog.
     * 
     * @param title   The title of the error dialog.
     * @param message The error message to display.
     */
    public static void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        MyLogger.logger.log(Level.FINE, title + " " + message);
        alert.showAndWait();
    }
}

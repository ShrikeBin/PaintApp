import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * @brief Custom simle button that displays given pop-up.
 */
public class InfoButton extends Button
{

    /**
     * @brief Constructor for the Info button.
     *
     * @param text     The text to be displayed on the button.
     * @param infoText The text to be displayed in the popup.
     */
    public InfoButton(String text, String infoText) 
    {
        super(text);

        // Set the event handler for button click
        setOnAction(event ->
        {
            // Create an Alert popup with information message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(infoText);

            // For longer information setting bigger widht
            alert.getDialogPane().setPrefWidth(600);
            
            // Show the popup
            alert.showAndWait();
        });
    }
}

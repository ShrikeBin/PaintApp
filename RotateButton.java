import javafx.scene.control.RadioButton;

/**
 * @brief RotateButton is a custom RadioButton for enabling rotate functionality in the Paint application.
 */
public class RotateButton extends RadioButton
{
    /**
     * @brief Constructs a RotateButton with the specified text and sets up the event handler.
     *
     * @param text The text to display on the button.
     * @param paneController The controller to manage the pane and shape behaviors.
     */
    public RotateButton(String text, PaneController paneController) 
    {
        super(text);

        // Add event handler for selection change
        selectedProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue) 
            {
                MyHandler.changeEventsRotate(paneController);
                paneController.setRotate(true);
            }
        });
    }
}

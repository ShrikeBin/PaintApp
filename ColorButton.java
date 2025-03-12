import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * @brief A custom button that allows painting the selected shape with a chosen color.
 */
public class ColorButton extends Button
{
    /**
     * @brief Constructs a ColorButton with the specified title, PaneController, and ColorPicker.
     * 
     * @param title           The title displayed on the button.
     * @param paneController The PaneController to handle shape painting.
     * @param colorPicker    The ColorPicker to choose the color for painting.
     */
    public ColorButton(String title, PaneController paneController, ColorPicker color) 
    {
        super(title);

        // Set initial color to black
        color.setValue(Color.BLACK);

        // Set action to paint the selected shape with the chosen color
        setOnAction(event -> 
        {
            if(paneController.getSelectedShape() != null)
            {
                paneController.getSelectedShape().paintSelf(color.getValue());
            }
        });
    }
}

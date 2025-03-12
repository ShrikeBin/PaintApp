import javafx.scene.control.Button;
import java.util.Iterator;

/**
 * @brief A custom button that deletes the selected shape from the PaintPane.
 */

public class DeleteButton extends Button
{
    /**
     * @brief Constructs a DeleteButton with the specified title and PaneController.
     * 
     * @param title           The title displayed on the button.
     * @param paneController  The PaneController to handle shape deletion.
     */
    public DeleteButton(String title, PaneController paneController)
    {   
        super(title);

        // Set action to delete the selected shape
        setOnAction(event -> 
        {
            if(paneController.getSelectedShape() != null)
            {
                // Remove the selected shape from the PaintPane
                paneController.getPaintPane().getChildren().remove(paneController.getSelectedShape().getSelf());
                
                // Use an iterator to safely remove the shape from the shape list
                Iterator<IMyShape> iterator = paneController.getPaintPane().getShapeList().iterator();
                while (iterator.hasNext()) 
                {
                    IMyShape shape = iterator.next();

                    // If the shape is equal to the selected shape, remove it from the list
                    if (shape.equals(paneController.getSelectedShape())) 
                    {
                        iterator.remove();
                        break;
                    }
                }

                // Clear the selection after deletion
                paneController.setSelectedShape(null);
            }
        });
    }
}

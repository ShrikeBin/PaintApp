import javafx.geometry.Point2D;
import java.util.logging.Level;

/**
 * @brief PaneHandler sets up event handlers for the PaintPane to manage user interactions.
 */
public class PaneHandler 
{
    /**
     * @brief Private constructor to prevent instantiation of this static utility class.
     */
    private PaneHandler() 
    {
        throw new InstantiationError("This is a static class");
    }

    /**
     * @brief Sets the mouse event handlers for the specified PaintPane and PaneController.
     *
     * @param paintPane The PaintPane to set the handlers on.
     * @param paneController The PaneController to control the PaintPane.
     */
    public static void setHandlers(PaintPane paintPane, PaneController paneController) 
    {
        paintPane.setOnMousePressed(event ->
        {
            MyLogger.logger.log(Level.FINE, "Pressed on the Pane at: " + event.getX() + " " + event.getY());

            if (paneController.isCreateMode()) 
            {
                paneController.startDrawing(new Point2D(event.getX(), event.getY()));
            }
        });

        paintPane.setOnMouseDragged(event ->
        {
            if (paneController.isCreateMode()) 
            {
                paneController.drawShape(new Point2D(event.getX(), event.getY()), paintPane.getShapeBox().getValue());
            } 
            else if (paneController.getSelectedShape() != null && paneController.isMoveShape()) 
            {
                paneController.getSelectedShape().moveSelf(new Point2D(event.getX(), event.getY()));
            }
        });

        paintPane.setOnMouseReleased(event ->
        {
            MyLogger.logger.log(Level.FINE, "Released on the Pane at: " + event.getX() + " " + event.getY());

            if (paneController.isCreateMode()) 
            {
                paneController.finishDrawing(new Point2D(event.getX(), event.getY()), paintPane.getShapeBox().getValue(), paintPane.getColorPicker().getValue());
            } 
            else if (paneController.getSelectedShape() != null && paneController.isMoveShape()) 
            {
                paneController.setMoveShape(false);
                MyLogger.logger.log(Level.FINE, "Stopped moving at: " + event.getX() + " " + event.getY());
            }
        });
    }
}

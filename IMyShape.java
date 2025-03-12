import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * @brief Represents a shape in the application.
 */
public interface IMyShape 
{
    
    /**
     * @brief Sets the event handler for mouse clicks on the shape.
     * 
     * @param handler The event handler for mouse clicks.
     */
    abstract void setMouseClicked(EventHandler<MouseEvent> handler);

    /**
     * @brief Sets the event handler for mouse press on the shape.
     * 
     * @param handler The event handler for mouse press.
     */
    abstract void setMousePressed(EventHandler<MouseEvent> handler);

    /**
     * @brief Sets the event handler for mouse scroll on the shape.
     * 
     * @param handler The event handler for mouse scroll.
     */
    abstract void setScroll(EventHandler<ScrollEvent> handler);

    /**
     * @brief Paints the shape with the given color.
     * 
     * @param color The color to paint the shape with.
     */
    abstract void paintSelf(Color color);

    /**
     * @brief Sets the outline color of the shape.
     * 
     * @param color The color to set as outline.
     */
    abstract void setOutline(Color color);

    /**
     * @brief Returns the current color of the shape.
     * 
     * @return The color of the shape.
     */
    abstract Color getColor();

    /**
     * @brief Rotates the shape by a given angle.
     * 
     * @param deltaAngle The angle by which to rotate the shape.
     */
    abstract void rotateSelf(final double deltaAngle);

    /**
     * @brief Resizes the shape by a given scale factor.
     * 
     * @param deltaScale The scale factor by which to resize the shape.
     */
    abstract void resizeSelf(final double deltaScale);

    /**
     * @brief Moves the shape to a specified destination.
     * 
     * @param destination The destination point to move the shape to.
     */
    abstract void moveSelf(Point2D destination);

    /**
     * @brief Returns the shape object.
     * 
     * @return The shape object.
     */
    abstract Shape getSelf();

    /**
     * @brief Returns the list of basic points defining the shape.
     * 
     * @return The list of basic points.
     */
    abstract List<Point2D> getBasicPoints(); 

    /**
     * @brief Sets the list of basic points defining the shape.
     * 
     * @param points The list of basic points to set.
     */
    abstract void setBasicPoints(List<Point2D> points);

    /**
     * @brief Checks if the given coordinates are inside the shape.
     * 
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the coordinates are inside the shape, otherwise false.
     */
    abstract boolean isInside(final double x, final double y);

    /**
     * @brief Returns the data representation of the shape.
     * 
     * @return The data representation of the shape.
     */
    abstract ShapeData getData();
}

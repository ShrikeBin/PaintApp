import javafx.geometry.Point2D;
import java.util.List;

/**
 * @brief A utility class for calculating delta values for moving shapes to a destination point.
 */

public class Delta 
{   
    // Private constructor to prevent instantiation of this static class
    private Delta()
    {
        throw new InstantiationError("Static class");
    }

    /**
     * @brief Calculates the delta for moving a triangle shape to a destination point.
     * 
     * @param destination   The destination point.
     * @param basicPoints   The list of basic points defining the triangle shape.
     * @return              The delta point for moving the triangle shape.
     */
    public static Point2D calculateTriangle(Point2D destination, List<Point2D> basicPoints) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY() + ((basicPoints.get(0).getY() - basicPoints.get(1).getY()) / 2);

        return new Point2D(deltaX, deltaY);
    }

    /**
     * @brief Calculates the delta for moving an ellipse shape to a destination point.
     * 
     * @param destination   The destination point.
     * @param basicPoints   The list of basic points defining the ellipse shape.
     * @return              The delta point for moving the ellipse shape.
     */
    public static Point2D calculateEllipse(Point2D destination, List<Point2D> basicPoints) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY();

        return new Point2D(deltaX, deltaY);
    }

    /**
     * @brief Calculates the delta for moving a rectangle shape to a destination point.
     * 
     * @param destination   The destination point.
     * @param basicPoints   The list of basic points defining the rectangle shape.
     * @param rectangle     The rectangle shape object.
     * @return              The delta point for moving the rectangle shape.
     */
    public static Point2D calculateRectangle(Point2D destination, List<Point2D> basicPoints, MyRectangle rectangle) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX() - rectangle.getWidth()/2;
        double deltaY = destination.getY() - basicPoints.get(0).getY() - rectangle.getHeight()/2;

        return new Point2D(deltaX, deltaY);
    }
}


import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * @brief ShapeFactory is responsible for creating shapes based on their codename.
 * It uses a map to store suppliers for each shape type.
 */
public class ShapeFactory 
{
    private final HashMap<String, Supplier<IMyShape>> shapeMap;

    /**
     * @brief Constructs a new ShapeFactory.
     * Initializes the shapeMap to store shape suppliers.
     */
    public ShapeFactory() 
    {
        shapeMap = new HashMap<>();
    }

    /**
     * @brief Registers a shape supplier with a given codename.
     *
     * @param codename The name associated with the shape.
     * @param supplier The supplier function that creates an instance of the shape.
     */
    public void registerShape(String codename, Supplier<IMyShape> supplier) 
    {
        shapeMap.put(codename, supplier);
    }

    /**
     * @brief Creates a shape based on its codename, points, and color.
     *
     * @param codename The name of the shape to create.
     * @param points A list of points defining the shape.
     * @param color The color to paint the shape.
     * @return An instance of IMyShape or null if the shape cannot be created.
     */
    public IMyShape createShape(final String codename, final List<Point2D> points, final Color color) 
    {
        Supplier<IMyShape> supplier = shapeMap.get(codename);

        if (supplier != null && points.size() == 2) 
        {
            IMyShape shape = supplier.get();
            shape.setBasicPoints(points);
            shape.paintSelf(color);
            return shape;
        } 
        else 
        {
            MyLogger.logger.log(Level.FINE, "Unable to create shape for codename: " + codename);
            return null;
        }
    }
}

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @brief ShapeData stores the properties of a shape for serialization.
 * This includes the coordinates of the shape, its color, rotation angle,
 * and scale factor.
 */
public class ShapeData implements Serializable
{
    // Coordinates of the shape's defining points (first and second points)
    private double firstX;
    private double firstY;
    private double secondX;
    private double secondY;

    // Other primitive properties
    private double rotationAngle;
    private double scaleFactor;
    private String codename;

    // Color properties
    private double red;
    private double green;
    private double blue;
    private double opacity;

    /**
     * @brief Constructs a new ShapeData object with the given name.
     *
     * @param name The name of the shape.
     */
    public ShapeData(String name)
    {
        this.codename = name;
        this.firstX = 0;
        this.firstY = 0;
        this.secondX = 0;
        this.secondY = 0;
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.opacity = 1.0;
        this.rotationAngle = 0;
        this.scaleFactor = 1.0;
    }

    // Setters for various properties
    public void setName(String name)
    {
        this.codename = name;
    }

    public void setFirstPoint(Point2D start)
    {
        this.firstX = start.getX();
        this.firstY = start.getY();
    }

    public void setSecondPoint(Point2D end)
    {
        this.secondX = end.getX();
        this.secondY = end.getY();
    }

    public void setMyColor(Color color)
    {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        this.opacity = color.getOpacity();
    }

    public void setMyRotationAngle(double rotationAngle)
    {
        this.rotationAngle = rotationAngle;
    }

    public void setMyScaleFactor(double scaleFactor)
    {
        this.scaleFactor = scaleFactor;
    }

    // Methods to adjust the coordinates
    public void addDeltaX(double value)
    {
        this.firstX += value;
        this.secondX += value;
    }

    public void addDeltaY(double value)
    {
        this.firstY += value;
        this.secondY += value;
    }

    // Getters for various properties
    public List<Point2D> getPoints()
    {
        return Arrays.asList(new Point2D(firstX, firstY), new Point2D(secondX, secondY));
    }

    public Color getMyColor()
    {
        return new Color(red, green, blue, opacity);
    }

    public String getName()
    {
        return codename;
    }

    public double getMyRotationAngle()
    {
        return rotationAngle;
    }

    public double getMyScaleFactor()
    {
        return scaleFactor;
    }
}

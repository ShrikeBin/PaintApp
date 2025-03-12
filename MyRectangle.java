import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import java.util.List;
import java.lang.Math;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @brief Represents a custom rectangle shape.
 */
public class MyRectangle extends Rectangle implements IMyShape
{
    private List<Point2D> basicPoints;
    private ShapeData data;

    /**
     * @brief Constructs a new MyRectangle object.
     */
    MyRectangle()
    {
        super(0, 0, 0, 0);
        setStrokeWidth(2);
        data = new ShapeData("Rectangle");
    }

    @Override 
    public void setMouseClicked(EventHandler<MouseEvent> handler) { setOnMouseClicked(handler); }

    @Override 
    public void setMousePressed(EventHandler<MouseEvent> handler) { setOnMousePressed(handler); }

    @Override 
    public void setScroll(EventHandler<ScrollEvent> handler) { setOnScroll(handler); }

    @Override 
    public void setOutline(Color color) { setStroke(color); }

    @Override
    public void paintSelf(Color color) { setFill(color); data.setMyColor((Color) color); }

    @Override 
    public Color getColor() { return (Color) getFill(); }

    @Override
    public Shape getSelf() { return this; }

    @Override 
    public boolean isInside(final double x, final double y) { return contains(x, y); }

    @Override
    public List<Point2D> getBasicPoints() { return basicPoints; }

    @Override
    public ShapeData getData() { return data; }

    @Override
    public void setBasicPoints(List<Point2D> points)
    {
        if (points.size() >= 2) 
        {
            basicPoints = points;
            setX(Math.min(basicPoints.get(0).getX(), basicPoints.get(1).getX()));
            setY(Math.min(basicPoints.get(0).getY(), basicPoints.get(1).getY()));
            setWidth(Math.abs(basicPoints.get(1).getX() - basicPoints.get(0).getX()));
            setHeight(Math.abs(basicPoints.get(1).getY() - basicPoints.get(0).getY()));
            
            //serialization
            data.setFirstPoint(basicPoints.get(0));
            data.setSecondPoint(basicPoints.get(1));   
        }
    }

    @Override
    public void rotateSelf(final double deltaAngle)
    {
        setRotate(getRotate() + deltaAngle);

        //serialization
        data.setMyRotationAngle(data.getMyRotationAngle() + deltaAngle);
    }

    @Override
    public void resizeSelf(final double deltaScale)
    {
        setScaleX(getScaleX() * deltaScale);
        setScaleY(getScaleY() * deltaScale);

        //serialization
        data.setMyScaleFactor(data.getMyScaleFactor() * deltaScale);
    }

    @Override
    public void moveSelf(Point2D destination)
    {
        setTranslateX(Delta.calculateRectangle(destination, basicPoints, this).getX());
        setTranslateY(Delta.calculateRectangle(destination, basicPoints, this).getY());

        //serialization
        data.addDeltaX(Delta.calculateRectangle(destination, data.getPoints(), this).getX());
        data.addDeltaY(Delta.calculateRectangle(destination, data.getPoints(), this).getY());
    }
}

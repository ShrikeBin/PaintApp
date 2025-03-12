import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import java.util.List;
import java.lang.Math;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * @brief Represents an ellipse shape in the application.
 */
public class MyEllipse extends Ellipse implements IMyShape
{
    private List<Point2D> basicPoints;
    private ShapeData data;

    /**
     * @brief Constructs a new ellipse shape with default properties.
     */
    MyEllipse()
    { 
        super(0, 0, 0, 0); 
        setStrokeWidth(2);
        data = new ShapeData("Ellipse"); 
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
            setCenterX(basicPoints.get(0).getX());
            setCenterY(basicPoints.get(0).getY());
            setRadiusX(Math.abs(basicPoints.get(0).getX() - basicPoints.get(1).getX()));
            setRadiusY(Math.abs(basicPoints.get(0).getY() - basicPoints.get(1).getY()));

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
        setTranslateX(Delta.calculateEllipse(destination, basicPoints).getX());
        setTranslateY(Delta.calculateEllipse(destination, basicPoints).getY());

        //serialization
        data.addDeltaX(Delta.calculateEllipse(destination, data.getPoints()).getX());
        data.addDeltaY(Delta.calculateEllipse(destination, data.getPoints()).getY());
    }
}

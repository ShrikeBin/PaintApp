import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * @brief Represents a custom triangle shape.
 */
public class MyTriangle extends Polygon implements IMyShape
{   
    private List<Point2D> basicPoints;
    private ShapeData data;

    /**
     * @brief Constructs a new MyTriangle object.
     */
    MyTriangle()
    {
        super(0, 0, 0, 0, 0, 0);
        setStrokeWidth(2);
        data = new ShapeData("Triangle");
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
    public boolean isInside(final double x, final double y) { return contains(x - this.getTranslateX(), y - this.getTranslateY()); }

    @Override
    public List<Point2D> getBasicPoints() { return basicPoints; }

    @Override
    public ShapeData getData() { return data; }

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
    public void moveSelf(Point2D destination) //IS GOOOD
    {   
        setTranslateX(Delta.calculateTriangle(destination, basicPoints).getX());
        setTranslateY(Delta.calculateTriangle(destination, basicPoints).getY());

        data.addDeltaX(Delta.calculateTriangle(destination, data.getPoints()).getX());
        data.addDeltaY(Delta.calculateTriangle(destination, data.getPoints()).getY());
    }

    @Override
    public void setBasicPoints(List<Point2D> points)
    {
        if(points.size() == 2)
        {
            basicPoints = points;
            Point2D apexPoint = points.get(0);
            Point2D basePoint1 = points.get(1);
            
            // Calculate the midpoint between basePoint1 and basePoint2
            Point2D basePoint2 = new Point2D(2 * apexPoint.getX() - basePoint1.getX(), basePoint1.getY());

            // Clear the existing points and set the new points
            getPoints().clear();
            getPoints().addAll(apexPoint.getX(), apexPoint.getY(),
                               basePoint1.getX(), basePoint1.getY(),
                               basePoint2.getX(), basePoint2.getY());

            //serialization
            data.setFirstPoint(basicPoints.get(0));
            data.setSecondPoint(basicPoints.get(1));   
        }
    }
}

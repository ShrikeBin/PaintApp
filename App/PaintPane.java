import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

/**
 * @brief PaintPane is a custom pane that holds and manages drawable shapes.
 * It interacts with a ComboBox for shape selection and a ColorPicker for setting shape colors.
 */
public class PaintPane extends Pane 
{
    private ArrayList<IMyShape> shapeList = new ArrayList<>();
    private ComboBox<String> shapeBox;
    private ColorPicker colorPicker;

    /**
     * @brief Constructs a PaintPane with specified shape selection ComboBox and color picker.
     *
     * @param shapeBox ComboBox for selecting shapes to draw.
     * @param colorPicker ColorPicker for selecting the color of shapes.
     */
    public PaintPane(ComboBox<String> shapeBox, ColorPicker colorPicker) 
    {
        super();
        this.shapeBox = shapeBox;
        this.colorPicker = colorPicker;
    }

    /**
     * @brief Gets the list of shapes currently in the pane.
     *
     * @return ArrayList of IMyShape objects.
     */
    public ArrayList<IMyShape> getShapeList() 
    {
        return shapeList;
    }

    /**
     * @brief Gets the ComboBox used for selecting shapes.
     *
     * @return ComboBox for shape selection.
     */
    public ComboBox<String> getShapeBox() 
    {
        return shapeBox;
    }

    /**
     * @brief Gets the ColorPicker used for selecting shape colors.
     *
     * @return ColorPicker for color selection.
     */
    public ColorPicker getColorPicker() 
    {
        return colorPicker;
    }
}

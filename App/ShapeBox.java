import javafx.scene.control.ComboBox;

/**
 * @brief ShapeBox is a custom ComboBox for selecting shapes in the Paint application.
 */
public class ShapeBox extends ComboBox<String>
{
    /**
     * @brief Constructs a ShapeBox with the specified shapes.
     *
     * @param shapes An array of shape names to populate the ComboBox.
     */
    ShapeBox(String[] shapes)
    {
        super();
        // Add the shape names to the ComboBox items
        getItems().addAll(shapes);
    }
}

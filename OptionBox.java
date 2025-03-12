import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * @brief Represents the option box containing various controls for the application.
 */
public class OptionBox extends BorderPane
{
    /**
     * @brief Constructs a new OptionBox with the specified controls.
     * @param shapes The combo box for selecting shapes.
     * @param color The color picker for selecting colors.
     * @param createMode The button for toggling create mode.
     * @param paint The button for changing shape color.
     * @param rotate The button for toggling rotation mode.
     * @param resize The button for toggling resize mode.
     * @param fileMenuBar The menu bar for file operations.
     * @param delete The button for deleting shapes.
     */
    OptionBox(ComboBox<String> shapes, ColorPicker color, ButtonBase createMode, ButtonBase paint, ButtonBase rotate, ButtonBase resize, MenuBar filMenuBar, ButtonBase delete)
    {
        super();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(shapes, 0, 0);
        gridPane.add(color, 1, 0);
        gridPane.add(createMode, 0, 1);
        gridPane.add(paint, 1, 1);
        gridPane.add(rotate, 0, 2);
        gridPane.add(resize, 1, 2);
        gridPane.add(filMenuBar, 2, 0);
        gridPane.add(delete, 2, 1);

        setCenter(gridPane);
    }
}

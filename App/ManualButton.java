/**
 * @brief Button displaying UserManual.
 */

public class ManualButton extends InfoButton
{
    ManualButton()
    {
        super("User Manual", "Usage of the program: \n" +
                "1. Manipulating Shapes:\n" +
                "   - Select a shape and use the buttons to rotate, resize, or move it.\n" +
                "2. Changing Scroll Mode:\n" +
                "   - Use radio buttons to switch between rotation and resizing mode.\n" +
                "3. Deleting Shapes:\n" +
                "   - Select a shape and press delete to remove it from the screen.\n" +
                "4. Changing Mode:\n" +
                "   - Use the 'Mark' button to mark shapes or 'Create' button to create new ones.\n" +
                "5. Creating Shapes:\n" +
                "   - Choose a figure type from the ComboBox and click 'Create' to draw it.\n" +
                "6. File Operations:\n" +
                "   - Save your figures to a file or load previously saved figures.\n");
    }
}


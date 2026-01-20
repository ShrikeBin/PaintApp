import javafx.scene.control.ToggleButton;

/**
 * @brief A custom toggle button for enabling drawing mode in the application.
 */
public class DrawButton extends ToggleButton {

    /**
     * @brief Constructs a new DrawButton with the specified PaneController.
     * 
     * @param paneController The PaneController instance to control drawing behavior.
     */
    public DrawButton(PaneController paneController) {
        super("Create / [Mark]");

        setOnAction(event -> {
            paneController.setCreateMode(isSelected());
            if (paneController.isCreateMode()) {
                setText("[Create] / Mark");
                paneController.clearSelection();
            } else {
                setText("Create / [Mark]");
            }
        });
    }
}

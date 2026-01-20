import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @brief Represents a menu bar with file-related options.
 */
public class FileMenu extends MenuBar {

    private ShapeLoader shapeLoader;

    /**
     * @brief Constructs a new FileMenu instance with ShapeData save/load functions.
     * 
     * @param paneController The PaneController managing the PaintPane.
     * @param primaryStage   The primary stage of the application.
     * @param factory         The ShapeFactory used to create shapes.
     */
    public FileMenu(PaneController paneController, Stage primaryStage, ShapeFactory factory) 
    {
        this.shapeLoader = ShapeLoader.getInstance();

        // Create File menu
        Menu fileMenu = new Menu("File");

        // Create Load option
        MenuItem loadMenuItem = new MenuItem("Load");

        loadMenuItem.setOnAction(e -> {
            shapeLoader.clearData();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                try 
                {
                    // Load shapes from file
                    shapeLoader.load(file);
                    paneController.getPaintPane().getShapeList().clear();
                    paneController.getPaintPane().getChildren().clear();
                    paneController.setCreateMode(false);
                    paneController.setMoveShape(false);
                    paneController.setRotate(false);
                    
                    // Iterate through loaded shapes and add them to PaintPane
                    for (ShapeData shape : shapeLoader.getShapes()) 
                    {
                        MyLogger.logger.log(Level.FINE, shape.getName() + " was loaded");
                        IMyShape object = factory.createShape(shape.getName(), shape.getPoints(), shape.getMyColor());
                        paneController.getPaintPane().getShapeList().add(object);
                        MyHandler.setBasicEvents(object, paneController, paneController.isRotate());
                        paneController.getPaintPane().getChildren().add(object.getSelf());
                        object.rotateSelf(shape.getMyRotationAngle());
                        object.resizeSelf(shape.getMyScaleFactor());
                    }
                } 
                catch (IOException | ClassNotFoundException ex) 
                {
                    ErrorHandler.showError("Unable to load file", ex.getMessage());
                }
            }
        });

        // Create Save option
        MenuItem saveMenuItem = new MenuItem("Save");
        
        saveMenuItem.setOnAction(e -> {
            shapeLoader.clearData();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            File file = fileChooser.showSaveDialog(primaryStage);

            if (file != null) {
                try 
                {
                    // Save shapes to file
                    for (IMyShape shape : paneController.getPaintPane().getShapeList()) 
                    {
                        shapeLoader.add(shape.getData());
                        MyLogger.logger.log(Level.FINE, shape.getData().getName() + " was saved");
                    }
                    shapeLoader.save(file);
                } 
                catch (IOException ex) 
                {
                    ErrorHandler.showError("Unable to save file", ex.getMessage());
                }
            }
        });

        // Add options to File menu
        fileMenu.getItems().addAll(loadMenuItem, saveMenuItem);

        // Add File menu to MenuBar
        this.getMenus().add(fileMenu);
    }
}

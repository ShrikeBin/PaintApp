import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * @brief Singleton class responsible for loading and saving shape data.
 */
public class ShapeLoader
{
    private static ShapeLoader instance;
    private ArrayList<ShapeData> shapes; /**< List to store shape data */

    /**
     * @brief Private constructor to prevent direct instantiation.
     */
    private ShapeLoader()
    {
        shapes = new ArrayList<ShapeData>(); /**< Initialize the list */
    }

    /**
     * @brief Get the instance of the ShapeLoader class.
     * @return The instance of ShapeLoader.
     */
    public static synchronized ShapeLoader getInstance() 
    {
        if (instance == null) 
        {
            instance = new ShapeLoader();
        }
        return instance;
    }

    /**
     * @brief Add shape data to the list.
     * @param shape The shape data to be added.
     */
    public void add(ShapeData shape)
    {
        shapes.add(shape);
    }

    /**
     * @brief Clear the shape data list.
     */
    public void clearData()
    {
        shapes = new ArrayList<ShapeData>(); /**< Create a new empty list */
    }

    /**
     * @brief Set the shape data list with a new list.
     * @param inputList The new list of shape data.
     */
    public void setShapes(ArrayList<ShapeData> inputList) 
    {
        shapes = inputList;
    }

    /**
     * @brief Get the list of shape data.
     * @return The list of shape data.
     */
    public ArrayList<ShapeData> getShapes() 
    {   
        MyLogger.logger.log(Level.FINE,"got shapes in number: " + Integer.toString(shapes.size()));
        return shapes;
    }

    /**
     * @brief Save shape data to a file.
     * @param file The file to save the data to.
     * @throws IOException If an I/O error occurs.
     */
    public void save(File file) throws IOException 
    {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        try 
        {
            // Serialize each shape and write to the file
            for (ShapeData shape : shapes) 
            {
                objectOutputStream.writeObject(shape);
            }
        } 
        catch (IOException e) 
        {
            MyLogger.logger.log(Level.FINE, "Unable to save file ", e);
        } 
        finally 
        {
            try 
            {
                objectOutputStream.close(); // Close the ObjectOutputStream
            } 
            catch (IOException e) 
            {
                MyLogger.logger.log(Level.FINE, "Error closing ObjectOutputStream", e);
            }
            try 
            {
                fileOutputStream.close(); // Close the FileOutputStream
            } 
            catch (IOException e) 
            {
                MyLogger.logger.log(Level.FINE, "Error closing FileOutputStream", e);
            }
        }
    }

    /**
     * @brief Load shape data from a file.
     * @param file The file to load the data from.
     * @throws IOException If an I/O error occurs.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public void load(File file) throws IOException, ClassNotFoundException 
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try 
        {
            shapes.clear(); // Clear existing shapes

            // Read each serialized shape from the file and add to the list
            while (true) 
            {
                ShapeData shape = (ShapeData) objectInputStream.readObject();
                shapes.add(shape);
            }
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            MyLogger.logger.log(Level.FINE, "Unable to load file ", e);
        } 
        finally 
        {
            try 
            {
                objectInputStream.close(); // Close the ObjectInputStream
            } 
            catch (IOException e) 
            {
                MyLogger.logger.log(Level.FINE, "Error closing ObjectInputStream", e);
            }
            try 
            {
                fileInputStream.close(); // Close the FileInputStream
            } 
            catch (IOException e) 
            {
                MyLogger.logger.log(Level.FINE, "Error closing FileInputStream", e);
            }
        }
    }
}
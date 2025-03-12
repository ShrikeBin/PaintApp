import java.io.IOException;
import java.util.logging.*;

/**
 * @brief Provides logging functionality.
 */
public class MyLogger
{
    private MyLogger()
    {
        throw new InstantiationError("MyLogger is a static class");
    }

    /** @brief Global logger instance. */
    public static final Logger logger = Logger.getGlobal();

    /**
     * @brief Configures the logger.
     */
    public static void loggerConfig()
    {
        // Disable parent handlers
        logger.setUseParentHandlers(false);

        // Add console handler
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        ch.setFormatter(new SimpleFormatter());
        logger.addHandler(ch);

        try
        {
            // Add file handler
            FileHandler fh = new FileHandler("./log.txt");
            fh.setLevel(Level.ALL);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        }
        catch (IOException | SecurityException e)
        {
            // Log error if file handler creation fails
            logger.log(Level.SEVERE, "Error while creating FileHandler", e);
        }

        // Set logger level
        logger.setLevel(Level.ALL);
    }
}

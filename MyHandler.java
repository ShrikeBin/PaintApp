/**
 * @brief Provides static methods to set event handlers for shapes.
 */
public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MyHandler is a static class");
    }

    /**
     * @brief Sets basic event handlers for the given shape.
     * 
     * @param shape The shape to set event handlers for.
     * @param paneController The controller managing the shape.
     * @param rotate Indicates whether rotation is enabled for the shape.
     */
    public static void setBasicEvents(IMyShape shape, PaneController paneController, boolean rotate)
    {
        shape.setMouseClicked(event -> 
        {
            if (!paneController.isCreateMode()) 
            {
                paneController.setSelectedShape(shape);
            }
        });

        // Added to ensure start of moving Shape
        shape.setMousePressed(event ->
        {
            if (shape.equals(paneController.getSelectedShape())) 
            {
                paneController.setMoveShape(true);
            }
        });

        if (!rotate)
        {
            shape.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && shape.equals(paneController.getSelectedShape())) 
                {
                    if (event.getDeltaY() > 0) 
                    {
                        shape.resizeSelf(1.2);
                    } 
                    else
                    {
                        shape.resizeSelf(0.9);
                    }
                }
            });
        }
        else
        {
            shape.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && shape.equals(paneController.getSelectedShape())) 
                {
                    double deltaAngle = event.getDeltaY() / 10;
                    shape.rotateSelf(deltaAngle);
                }
            });
        }
    }

    /**
     * @brief Changes event handlers for rotation.
     * 
     * @param paneController The controller managing the shapes.
     */
    public static void changeEventsRotate(PaneController paneController)
    {
        for(IMyShape iter : paneController.getPaintPane().getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && iter.equals(paneController.getSelectedShape())) 
                {
                    double deltaAngle = event.getDeltaY() / 10;
                    iter.rotateSelf(deltaAngle);
                }
            });
        }
    }

    /**
     * @brief Changes event handlers for resizing.
     * 
     * @param paneController The controller managing the shapes.
     */
    public static void changeEventsResize(PaneController paneController)
    {
        for(IMyShape iter : paneController.getPaintPane().getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && iter.equals(paneController.getSelectedShape())) 
                {
                    if (event.getDeltaY() > 0) 
                    {
                        iter.resizeSelf(1.2);
                    } 
                    else
                    {
                        iter.resizeSelf(0.9);
                    }
                }
            });
        }
    }
}

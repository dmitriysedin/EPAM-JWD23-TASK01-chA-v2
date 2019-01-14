package by.epam.dmitriysedin.task01.util.creation;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;

/**
 * Created by Dmitriy Sedin on 14.01.2019.
 */
public class CreatorImpl implements Creator{

    public Point2D point2dCreate(){
        return new Point2D();
    }

    public Triangle triangleCreate(){
        return new Triangle();
    }
}

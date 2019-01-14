package by.epam.dmitriysedin.task01.util.creation;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;

/**
 * Created by Dmitriy Sedin on 14.01.2019.
 */
public interface Creator {

    Point2D point2dCreate();

    Triangle triangleCreate();
}

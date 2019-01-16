package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;

/**
 * Created by Dmitriy Sedin on 14.01.2019.
 */
public interface TriangleInit {

    void point2DInit(Point2D point, double abscissa, double ordinate);

    void triangleInit(Triangle triangle, Point2D apexA, Point2D apexB, Point2D apexC);

    Triangle[] triangleInit(String[] paramOfTriangle) throws Exception;
}

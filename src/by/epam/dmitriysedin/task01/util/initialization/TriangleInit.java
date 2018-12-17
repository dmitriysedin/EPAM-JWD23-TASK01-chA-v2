package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TriangleInit {

    public static void init(Triangle triangle, Point2D apexA, Point2D apexB,
                            Point2D apexC){

        triangle.setApexA(apexA);
        triangle.setApexB(apexB);
        triangle.setApexC(apexC);
    }
}

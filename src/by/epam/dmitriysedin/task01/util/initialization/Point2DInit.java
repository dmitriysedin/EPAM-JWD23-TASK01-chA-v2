package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Point2D;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class Point2DInit {

    public static void init(Point2D point, double abscissa, double ordinate){

        point.setAbscissa(abscissa);
        point.setOrdinate(ordinate);
    }
}

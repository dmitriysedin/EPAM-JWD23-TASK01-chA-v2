package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Point2D;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class Point2DInitImpl implements Initialization {

    Point2D point;
    double abscissa;
    double ordinate;

    public Point2DInitImpl(Point2D point, double abscissa, double ordinate) {
        this.point = point;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public void init(){

        this.point.setAbscissa(abscissa);
        this.point.setOrdinate(ordinate);
    }


}

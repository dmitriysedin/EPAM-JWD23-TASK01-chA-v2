package by.epam.dmitriysedin.task01.util.validation;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;

/**
 * Created by Dmitriy Sedin on 17.12.2018.
 */
public class SideValidation {

    public static boolean getSideValidation(Point2D apex1, Point2D apex2, double side){

        double abscissa1 = apex1.getAbscissa();
        double ordinate1 = apex1.getOrdinate();
        double abscissa2 = apex1.getAbscissa();
        double ordinate2 = apex1.getOrdinate();

        if((abscissa1 == Double.POSITIVE_INFINITY || abscissa1 == Double.NEGATIVE_INFINITY || new Double(abscissa1).isNaN()) ||
                (ordinate1 == Double.POSITIVE_INFINITY || ordinate1 == Double.NEGATIVE_INFINITY || new Double(ordinate1).isNaN()) ||
                (abscissa2 == Double.POSITIVE_INFINITY || abscissa2 == Double.NEGATIVE_INFINITY || new Double(abscissa2).isNaN()) ||
                (ordinate2 == Double.POSITIVE_INFINITY || ordinate2 == Double.NEGATIVE_INFINITY || new Double(ordinate2).isNaN())){
            return false;
        }

        return !(!apex1.equals(apex2) && (side == Double.POSITIVE_INFINITY || side == 0 || new Double(side).isNaN()));
    }
}

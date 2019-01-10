package by.epam.dmitriysedin.task01.util.validation;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;

/**
 * Created by Dmitriy Sedin on 15.12.2018.
 */
public class ResultValidation {

    public static boolean getResultValidation(Triangle triangle){

        Point2D apexA = triangle.getApexA();
        Point2D apexB = triangle.getApexB();
        Point2D apexC = triangle.getApexC();

        double abscissaA = apexA.getAbscissa();
        double ordinateA = apexA.getOrdinate();
        double abscissaB = apexB.getAbscissa();
        double ordinateB = apexB.getOrdinate();
        double abscissaC = apexC.getAbscissa();
        double ordinateC = apexC.getOrdinate();

        double sideAB = Math.sqrt((Math.pow(abscissaA - abscissaB, 2)) +
                (Math.pow(ordinateA - ordinateB, 2)));

        double sideAC = Math.sqrt((Math.pow(abscissaA - abscissaC, 2)) +
                (Math.pow(ordinateA - ordinateC, 2)));

        double sideBC = Math.sqrt((Math.pow(abscissaB - abscissaC, 2)) +
                (Math.pow(ordinateB - ordinateC, 2)));

        if((abscissaA == Double.POSITIVE_INFINITY || abscissaA == Double.NEGATIVE_INFINITY || new Double(abscissaA).isNaN()) ||
                (ordinateA == Double.POSITIVE_INFINITY || ordinateA == Double.NEGATIVE_INFINITY || new Double(ordinateA).isNaN()) ||
                (abscissaB == Double.POSITIVE_INFINITY || abscissaB == Double.NEGATIVE_INFINITY || new Double(abscissaB).isNaN()) ||
                (ordinateB == Double.POSITIVE_INFINITY || ordinateB == Double.NEGATIVE_INFINITY || new Double(ordinateB).isNaN()) ||
                (abscissaC == Double.POSITIVE_INFINITY || abscissaC == Double.NEGATIVE_INFINITY || new Double(abscissaC).isNaN()) ||
                (ordinateC == Double.POSITIVE_INFINITY || ordinateC == Double.NEGATIVE_INFINITY || new Double(ordinateC).isNaN())){
            return false;
        }

        return !((!apexA.equals(apexC) && (sideAC == Double.POSITIVE_INFINITY || sideAC == 0 || new Double(sideAC).isNaN())) ||
                (!apexB.equals(apexC) && (sideBC == Double.POSITIVE_INFINITY || sideBC == 0 || new Double(sideBC).isNaN())) ||
                (!apexA.equals(apexB) && (sideAB == Double.POSITIVE_INFINITY || sideAB == 0 || new Double(sideAB).isNaN())));
    }
}

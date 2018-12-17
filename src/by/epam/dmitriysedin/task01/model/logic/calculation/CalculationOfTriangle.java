package by.epam.dmitriysedin.task01.model.logic.calculation;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.SidesOfTriangle;
import by.epam.dmitriysedin.task01.model.logic.check.CheckOfTriangle;

import by.epam.dmitriysedin.task01.util.validation.ResultValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public final class CalculationOfTriangle {

    private CalculationOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(CalculationOfTriangle.class);

    public static double perimeterOfTriangle (Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <perimeterOfTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <perimeterOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <perimeterOfTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        logger.trace("<perimeterOfTriangle> is done");
        return SidesOfTriangle.getSideAB(triangle) + SidesOfTriangle.getSideAC(triangle) +
                SidesOfTriangle.getSideBC(triangle);
    }

    public static double areaOfTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <areaOfTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <areaOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <areaOfTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        double halfPerimeterOfTriangle = perimeterOfTriangle(triangle) / 2;

        logger.trace("<areaOfTriangle> is done");

        return Math.sqrt(halfPerimeterOfTriangle * (halfPerimeterOfTriangle - SidesOfTriangle.getSideAB(triangle)) *
                (halfPerimeterOfTriangle - SidesOfTriangle.getSideAC(triangle)) *
                (halfPerimeterOfTriangle - SidesOfTriangle.getSideBC(triangle)));
    }
}

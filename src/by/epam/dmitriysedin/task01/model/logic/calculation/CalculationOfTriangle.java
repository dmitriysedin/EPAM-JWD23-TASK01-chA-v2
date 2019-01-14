package by.epam.dmitriysedin.task01.model.logic.calculation;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.CalculationOfSidesOfTriangle;
import by.epam.dmitriysedin.task01.model.logic.check.CheckOfTriangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class CalculationOfTriangle {

    public CalculationOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(CalculationOfTriangle.class);

    public double calculatePerimeterOfTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!new CheckOfTriangle().isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <calculatePerimeterOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        logger.trace("<calculatePerimeterOfTriangle> is done");

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        return sideOfTriangle.calculateSideAB(triangle) + sideOfTriangle.calculateSideAC(triangle) +
                sideOfTriangle.calculateSideBC(triangle);
    }

    public double calculateAreaOfTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!new CheckOfTriangle().isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <calculateAreaOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double halfPerimeterOfTriangle = calculatePerimeterOfTriangle(triangle) / 2;

        logger.trace("<calculateAreaOfTriangle> is done");

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        return Math.sqrt(halfPerimeterOfTriangle * (halfPerimeterOfTriangle - sideOfTriangle.calculateSideAB(triangle)) *
                (halfPerimeterOfTriangle - sideOfTriangle.calculateSideAC(triangle)) *
                (halfPerimeterOfTriangle - sideOfTriangle.calculateSideBC(triangle)));
    }
}

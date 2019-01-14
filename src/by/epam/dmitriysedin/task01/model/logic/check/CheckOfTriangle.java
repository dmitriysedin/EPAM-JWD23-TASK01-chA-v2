package by.epam.dmitriysedin.task01.model.logic.check;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.CalculationOfSidesOfTriangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class CheckOfTriangle {

    public CheckOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(CalculationOfSidesOfTriangle.class);

    public boolean isTriangle(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException {

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double sideAB = sideOfTriangle.calculateSideAB(triangle);
        double sideAC = sideOfTriangle.calculateSideAC(triangle);
        double sideBC = sideOfTriangle.calculateSideBC(triangle);

        logger.trace("<isTriangle> is done");

        return sideAB + sideAC != sideBC && sideAB + sideBC != sideAC &&
                sideAC + sideBC != sideAB;
    }

    public boolean isEquilateralTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isEquilateralTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double sideAB = sideOfTriangle.calculateSideAB(triangle);
        double sideAC = sideOfTriangle.calculateSideAC(triangle);
        double sideBC = sideOfTriangle.calculateSideBC(triangle);

        logger.trace("<isEquilateralTriangle> is done");

        return sideAB == sideAC && sideAB == sideBC;
    }

    public boolean isIsoscelesTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isIsoscelesTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double sideAB = sideOfTriangle.calculateSideAB(triangle);
        double sideAC = sideOfTriangle.calculateSideAC(triangle);
        double sideBC = sideOfTriangle.calculateSideBC(triangle);

        logger.trace("<isIsoscelesTriangle> is done");

        return sideAB == sideAC || sideAB == sideBC || sideAC == sideBC;
    }

    public boolean isRightTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isRightTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double squareSideAB = Math.pow(sideOfTriangle.calculateSideAB(triangle), 2);
        double squareSideAC = Math.pow(sideOfTriangle.calculateSideAC(triangle), 2);
        double squareSideBC = Math.pow(sideOfTriangle.calculateSideBC(triangle), 2);

        logger.trace("<isRightTriangle> is done");

        return squareSideAB + squareSideAC == squareSideBC ||
                squareSideAB + squareSideBC == squareSideAC ||
                squareSideAC + squareSideBC == squareSideAB;
    }

    public boolean isAcuteTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isAcuteTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double squareSideAB = Math.pow(sideOfTriangle.calculateSideAB(triangle), 2);
        double squareSideAC = Math.pow(sideOfTriangle.calculateSideAC(triangle), 2);
        double squareSideBC = Math.pow(sideOfTriangle.calculateSideBC(triangle), 2);

        logger.trace("<isAcuteTriangle> is done");

        return squareSideAB + squareSideAC > squareSideBC &&
                squareSideAB + squareSideBC > squareSideAC &&
                squareSideAC + squareSideBC > squareSideAB;
    }

    public boolean isObtuseTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(!isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isObtuseTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        CalculationOfSidesOfTriangle sideOfTriangle = new CalculationOfSidesOfTriangle();

        double squareSideAB = Math.pow(sideOfTriangle.calculateSideAB(triangle), 2);
        double squareSideAC = Math.pow(sideOfTriangle.calculateSideAC(triangle), 2);
        double squareSideBC = Math.pow(sideOfTriangle.calculateSideBC(triangle), 2);

        logger.trace("<isObtuseTriangle> is done");

        return squareSideAB + squareSideAC < squareSideBC ||
                squareSideAB + squareSideBC < squareSideAC ||
                squareSideAC + squareSideBC < squareSideAB;
    }
}

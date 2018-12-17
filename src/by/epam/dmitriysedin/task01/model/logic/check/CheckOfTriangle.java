package by.epam.dmitriysedin.task01.model.logic.check;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.SidesOfTriangle;

import by.epam.dmitriysedin.task01.util.validation.ResultValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public final class CheckOfTriangle {

    private CheckOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(SidesOfTriangle.class);

    public static boolean isTriangle(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        double sideAB = SidesOfTriangle.getSideAB(triangle);
        double sideAC = SidesOfTriangle.getSideAC(triangle);
        double sideBC = SidesOfTriangle.getSideBC(triangle);

        logger.trace("<isTriangle> is done");

        return sideAB + sideAC != sideBC && sideAB + sideBC != sideAC &&
                sideAC + sideBC != sideAB;
    }

    public static boolean isEquilateralTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isEquilateralTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isEquilateralTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isEquilateralTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double sideAB = SidesOfTriangle.getSideAB(triangle);
        double sideAC = SidesOfTriangle.getSideAC(triangle);
        double sideBC = SidesOfTriangle.getSideBC(triangle);

        logger.trace("<isEquilateralTriangle> is done");

        return sideAB == sideAC && sideAB == sideBC;
    }

    public static boolean isIsoscelesTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isIsoscelesTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isIsoscelesTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isIsoscelesTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double sideAB = SidesOfTriangle.getSideAB(triangle);
        double sideAC = SidesOfTriangle.getSideAC(triangle);
        double sideBC = SidesOfTriangle.getSideBC(triangle);

        logger.trace("<isIsoscelesTriangle> is done");

        return sideAB == sideAC || sideAB == sideBC || sideAC == sideBC;
    }

    public static boolean isRightTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isRightTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isRightTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isRightTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double squareSideAB = Math.pow(SidesOfTriangle.getSideAB(triangle), 2);
        double squareSideAC = Math.pow(SidesOfTriangle.getSideAC(triangle), 2);
        double squareSideBC = Math.pow(SidesOfTriangle.getSideBC(triangle), 2);

        logger.trace("<isRightTriangle> is done");

        return squareSideAB + squareSideAC == squareSideBC ||
                squareSideAB + squareSideBC == squareSideAC ||
                squareSideAC + squareSideBC == squareSideAB;
    }

    public static boolean isAcuteTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isAcuteTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isAcuteTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isAcuteTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double squareSideAB = Math.pow(SidesOfTriangle.getSideAB(triangle), 2);
        double squareSideAC = Math.pow(SidesOfTriangle.getSideAC(triangle), 2);
        double squareSideBC = Math.pow(SidesOfTriangle.getSideBC(triangle), 2);

        logger.trace("<isAcuteTriangle> is done");

        return squareSideAB + squareSideAC > squareSideBC &&
                squareSideAB + squareSideBC > squareSideAC &&
                squareSideAC + squareSideBC > squareSideAB;
    }

    public static boolean isObtuseTriangle(Triangle triangle) throws TriangleNullException,
            NotTriangleException, DoubleOutOfBoundException {

        if(triangle == null || triangle.getApexA() == null || triangle.getApexB() == null ||
                triangle.getApexC() == null){
            logger.trace("TriangleNullException thrown in <isObtuseTriangle>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        if(!ResultValidation.getResultValidation(triangle)){
            logger.trace("DoubleOutOfBoundException thrown in <isObtuseTriangle>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <isObtuseTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double squareSideAB = Math.pow(SidesOfTriangle.getSideAB(triangle), 2);
        double squareSideAC = Math.pow(SidesOfTriangle.getSideAC(triangle), 2);
        double squareSideBC = Math.pow(SidesOfTriangle.getSideBC(triangle), 2);

        logger.trace("<isObtuseTriangle> is done");

        return squareSideAB + squareSideAC < squareSideBC ||
                squareSideAB + squareSideBC < squareSideAC ||
                squareSideAC + squareSideBC < squareSideAB;
    }
}

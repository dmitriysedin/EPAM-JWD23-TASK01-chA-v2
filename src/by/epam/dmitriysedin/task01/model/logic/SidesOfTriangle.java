package by.epam.dmitriysedin.task01.model.logic;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;

import by.epam.dmitriysedin.task01.util.validation.SideValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public final class SidesOfTriangle {

    private SidesOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(SidesOfTriangle.class);

    public static double getSideAB(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <getSideAB>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexA = triangle.getApexA();
        Point2D apexB = triangle.getApexB();

        if(apexA == null || apexB == null){
            logger.trace("TriangleNullException thrown in <getSideAB>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaA = apexA.getAbscissa();
        double ordinateA = apexA.getOrdinate();
        double abscissaB = apexB.getAbscissa();
        double ordinateB = apexB.getOrdinate();

        logger.trace("<getSideAB> is done");

        double sideAB = Math.sqrt((Math.pow(abscissaA - abscissaB, 2)) +
                (Math.pow(ordinateA - ordinateB, 2)));

        if(!SideValidation.getSideValidation(apexA, apexB, sideAB)){
            logger.trace("DoubleOutOfBoundException thrown in <getSideAB>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideAB;
    }

    public static double getSideAC(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <getSideAC>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexA = triangle.getApexA();
        Point2D apexC = triangle.getApexC();

        if(apexA == null || apexC == null){
            logger.trace("TriangleNullException thrown in <getSideAC>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaA = apexA.getAbscissa();
        double ordinateA = apexA.getOrdinate();
        double abscissaC = apexC.getAbscissa();
        double ordinateC = apexC.getOrdinate();

        logger.trace("<getSideAC> is done");

        double sideAC = Math.sqrt((Math.pow(abscissaA - abscissaC, 2)) +
                (Math.pow(ordinateA - ordinateC, 2)));

        if(!SideValidation.getSideValidation(apexA, apexC, sideAC)){
            logger.trace("DoubleOutOfBoundException thrown in <getSideAC>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideAC;
    }

    public static double getSideBC(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <getSideBC>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexB = triangle.getApexB();
        Point2D apexC = triangle.getApexC();

        if(apexB == null || apexC == null){
            logger.trace("TriangleNullException thrown in <getSideBC>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaB = apexB.getAbscissa();
        double ordinateB = apexB.getOrdinate();
        double abscissaC = apexC.getAbscissa();
        double ordinateC = apexC.getOrdinate();

        logger.trace("<getSideBC> is done");

        double sideBC = Math.sqrt((Math.pow(abscissaB - abscissaC, 2)) +
                (Math.pow(ordinateB - ordinateC, 2)));

        if(!SideValidation.getSideValidation(apexB, apexC, sideBC)){
            logger.trace("DoubleOutOfBoundException thrown in <getSideBC>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideBC;
    }
}

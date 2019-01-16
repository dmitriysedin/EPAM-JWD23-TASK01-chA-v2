package by.epam.dmitriysedin.task01.model.logic;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;

import by.epam.dmitriysedin.task01.util.validation.OutputDataValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class CalculationOfSidesOfTriangle {

    public CalculationOfSidesOfTriangle() {
    }

    private static final Logger logger = LogManager.getLogger(CalculationOfSidesOfTriangle.class);

    public double calculateSideAB(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <calculateSideAB>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexA = triangle.getApexA();
        Point2D apexB = triangle.getApexB();

        if(apexA == null || apexB == null){
            logger.trace("TriangleNullException thrown in <calculateSideAB>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaA = apexA.getAbscissa();
        double ordinateA = apexA.getOrdinate();
        double abscissaB = apexB.getAbscissa();
        double ordinateB = apexB.getOrdinate();

        logger.trace("<calculateSideAB> is done");

        double sideAB = Math.sqrt((Math.pow(abscissaA - abscissaB, 2)) +
                (Math.pow(ordinateA - ordinateB, 2)));

        if(!new OutputDataValidation().isDouble(sideAB)){
            logger.trace("DoubleOutOfBoundException thrown in <calculateSideAB>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideAB;
    }

    public double calculateSideAC(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <calculateSideAC>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexA = triangle.getApexA();
        Point2D apexC = triangle.getApexC();

        if(apexA == null || apexC == null){
            logger.trace("TriangleNullException thrown in <calculateSideAC>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaA = apexA.getAbscissa();
        double ordinateA = apexA.getOrdinate();
        double abscissaC = apexC.getAbscissa();
        double ordinateC = apexC.getOrdinate();

        logger.trace("<calculateSideAC> is done");

        double sideAC = Math.sqrt((Math.pow(abscissaA - abscissaC, 2)) +
                (Math.pow(ordinateA - ordinateC, 2)));

        if(!new OutputDataValidation().isDouble(sideAC)){
            logger.trace("DoubleOutOfBoundException thrown in <calculateSideAC>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideAC;
    }

    public double calculateSideBC(Triangle triangle) throws TriangleNullException, DoubleOutOfBoundException{

        if(triangle == null){
            logger.trace("TriangleNullException thrown in <calculateSideBC>");
            throw new TriangleNullException("Triangle is <null>");
        }

        Point2D apexB = triangle.getApexB();
        Point2D apexC = triangle.getApexC();

        if(apexB == null || apexC == null){
            logger.trace("TriangleNullException thrown in <calculateSideBC>");
            throw new TriangleNullException("Triangle has a <null> field.");
        }

        double abscissaB = apexB.getAbscissa();
        double ordinateB = apexB.getOrdinate();
        double abscissaC = apexC.getAbscissa();
        double ordinateC = apexC.getOrdinate();

        logger.trace("<calculateSideBC> is done");

        double sideBC = Math.sqrt((Math.pow(abscissaB - abscissaC, 2)) +
                (Math.pow(ordinateB - ordinateC, 2)));

        if(!new OutputDataValidation().isDouble(sideBC)){
            logger.trace("DoubleOutOfBoundException thrown in <calculateSideBC>");
            throw new DoubleOutOfBoundException("Some side of triangle is too large / too small");
        }

        return sideBC;
    }
}

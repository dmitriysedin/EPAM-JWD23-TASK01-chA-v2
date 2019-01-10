package by.epam.dmitriysedin.task01.model.logic.calculation;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.check.CheckOfTriangle;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.*;

/**
 * Created by Dmitriy Sedin on 07.12.2018.
 */
public class CalculationOfTriangleTest {

    private static final String SPLIT_REGEX = "\\s+";

    private static Triangle[] testTriangle;

    private String fileName = "files\\TestValues.txt";

    @BeforeClass
    public void initTestTriangleArrayFromFile() {

        List<Triangle> triangles = new ArrayList<>();

        String[] linesFromFile = null;

        try (Stream<String> streamFromFile = Files.lines(Paths.get(fileName))) {
            linesFromFile = streamFromFile.toArray(String[]::new);
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < linesFromFile.length; i++) {
            String[] paramOfTriangle = linesFromFile[i].split(SPLIT_REGEX);
            Triangle triangle = new Triangle(new Point2D(Double.parseDouble(paramOfTriangle[0]),
                    Double.parseDouble(paramOfTriangle[1])),
                    new Point2D(Double.parseDouble(paramOfTriangle[2]),
                            Double.parseDouble(paramOfTriangle[3])),
                    new Point2D(Double.parseDouble(paramOfTriangle[4]),
                            Double.parseDouble(paramOfTriangle[5])));
            triangles.add(triangle);
        }
        testTriangle = triangles.toArray(new Triangle[triangles.size()]);
    }

    @DataProvider
    public Object[][] perimeterOfTriangleData() {

        Object[][] perimeterOfTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            perimeterOfTriangleData[i][0] = sideAB + sideAC + sideBC;
            perimeterOfTriangleData[i][1] = testTriangle[i];
        }
        return perimeterOfTriangleData;
    }

    @DataProvider
    public Object[][] areaOfTriangleData() {

        Object[][] areaOfTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            double halfPerimeter = (sideAB + sideAC + sideBC) / 2;
            areaOfTriangleData[i][0] = Math.sqrt(halfPerimeter *
                    (halfPerimeter - sideAB) * (halfPerimeter - sideAC) * (halfPerimeter - sideBC));
            areaOfTriangleData[i][1] = testTriangle[i];
        }
        return areaOfTriangleData;
    }

    @Test(dataProvider = "perimeterOfTriangleData")
    public void testPerimeterOfTriangle(Double expected, Triangle triangle) throws Exception {
        double actual = CalculationOfTriangle.perimeterOfTriangle(triangle);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "areaOfTriangleData")
    public void testAreaOfTriangle(Double expected, Triangle triangle) throws Exception {
        double actual = CalculationOfTriangle.areaOfTriangle(triangle);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionOfAreaOfTriangle() throws Exception {
        Triangle triangle = null;
        CalculationOfTriangle.areaOfTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionOfAreaOfTriangleSide() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CalculationOfTriangle.areaOfTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionOfPerimeterOfTriangle() throws Exception {
        Triangle triangle = null;
        CalculationOfTriangle.perimeterOfTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionOfPerimeterOfTriangleSide() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CalculationOfTriangle.perimeterOfTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfPerimeterOfTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CalculationOfTriangle.perimeterOfTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfAreaOfTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CalculationOfTriangle.areaOfTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfPerimeterOfTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CalculationOfTriangle.perimeterOfTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfAreaOfTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CalculationOfTriangle.areaOfTriangle(triangle);
    }
}
package by.epam.dmitriysedin.task01.model.logic;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.*;

/**
 * Created by Dmitriy Sedin on 10.12.2018.
 */
public class CalculationOfSidesOfTriangleTest {

    private static final String SPLIT_REGEX = "\\s+";

    private static Triangle[] testTriangle;

    private String fileName = "files\\TestValues.txt";

    public CalculationOfSidesOfTriangle calculationOfSidesOfTriangle = new CalculationOfSidesOfTriangle();

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
    public Object[][] calculateSideABData(){

        Object[][] getSideABData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));

            getSideABData[i][0] = sideAB;
            getSideABData[i][1] = testTriangle[i];
        }
        return getSideABData;
    }

    @DataProvider
    public Object[][] calculateSideACData(){

        Object[][] getSideACData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            getSideACData[i][0] = sideAC;
            getSideACData[i][1] = testTriangle[i];
        }
        return getSideACData;
    }

    @DataProvider
    public Object[][] calculateSideBCData(){

        Object[][] getSideBCData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            getSideBCData[i][0] = sideBC;
            getSideBCData[i][1] = testTriangle[i];
        }
        return getSideBCData;
    }

    @Test(dataProvider = "calculateSideABData")
    public void testCalculateSideAB(Double expected, Triangle triangle) throws Exception {

        double actual = calculationOfSidesOfTriangle.calculateSideAB(triangle);

        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "calculateSideACData")
    public void testCalculateSideAC(Double expected, Triangle triangle) throws Exception {

        double actual = calculationOfSidesOfTriangle.calculateSideAC(triangle);

        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "calculateSideBCData")
    public void testCalculateSideBC(Double expected, Triangle triangle) throws Exception {

        double actual = calculationOfSidesOfTriangle.calculateSideBC(triangle);

        assertEquals(actual, expected, 0.000001);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullTriangleOfCalculateSideAB() throws Exception {
        Triangle triangle = null;
        calculationOfSidesOfTriangle.calculateSideAB(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullApexOfCalculateSideAB() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        calculationOfSidesOfTriangle.calculateSideAB(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullTriangleOfCalculateSideAC() throws Exception {
        Triangle triangle = null;
        calculationOfSidesOfTriangle.calculateSideAC(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullApexOfCalculateSideAC() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        calculationOfSidesOfTriangle.calculateSideAC(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullTriangleOfCalculateSideBC() throws Exception {
        Triangle triangle = null;
        calculationOfSidesOfTriangle.calculateSideBC(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testExceptionNullApexOfCalculateSideBC() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(new Point2D(0, 1), new Point2D(1, 2), point2D);
        calculationOfSidesOfTriangle.calculateSideBC(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfCalculateSideAB() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        calculationOfSidesOfTriangle.calculateSideAB(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfCalculateSideAC() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaC = Math.pow(1.25E308d, 2);
        double ordinataC = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(1, 2),
                new Point2D(abscissaC, ordinataC));
        calculationOfSidesOfTriangle.calculateSideAC(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfCalculateSideBC() throws Exception {
        double abscissaB = Math.pow(1.23E308d, 2);
        double ordinataB = Math.pow(1.24E308d, 2);
        double abscissaC = Math.pow(1.25E308d, 2);
        double ordinataC = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(1, 2), new Point2D(abscissaB, ordinataB),
                new Point2D(abscissaC, ordinataC));
        calculationOfSidesOfTriangle.calculateSideBC(triangle);
    }
}
package by.epam.dmitriysedin.task01.model.logic.check;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.DoubleOutOfBoundException;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.SidesOfTriangle;
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
 * Created by Dmitriy Sedin on 09.12.2018.
 */
public class CheckOfTriangleTest {

    private static final String SPLIT_REGEX = "\\s+";

    private static Triangle[] testTriangle;

    private String fileName = "D:\\EPAM_JWD23\\files\\TestValues.txt";

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
    public Object[][] isTriangleData() {

        Object[][] isTriangleData = new Object[testTriangle.length][2];

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

            isTriangleData[i][0] = sideAB + sideAC != sideBC && sideAB + sideBC != sideAC &&
                    sideAC + sideBC != sideAB;
            isTriangleData[i][1] = testTriangle[i];
        }
        return isTriangleData;
    }

    @DataProvider
    public Object[][] isEquilateralTriangleData() {

        Object[][] isEquilateralTriangleData = new Object[testTriangle.length][2];

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

            isEquilateralTriangleData[i][0] = sideAB == sideAC && sideAB == sideBC;
            isEquilateralTriangleData[i][1] = testTriangle[i];
        }
        return isEquilateralTriangleData;
    }

    @DataProvider
    public Object[][] isIsoscelesTriangleData() {

        Object[][] isIsoscelesTriangleData = new Object[testTriangle.length][2];

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

            isIsoscelesTriangleData[i][0] = sideAB == sideAC || sideAB == sideBC || sideAC == sideBC;
            isIsoscelesTriangleData[i][1] = testTriangle[i];
        }
        return isIsoscelesTriangleData;
    }

    @DataProvider
    public Object[][] isRightTriangleData() {

        Object[][] isRightTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isRightTriangleData[i][0] = squareSideAB + squareSideAC == squareSideBC ||
                    squareSideAB + squareSideBC == squareSideAC ||
                    squareSideAC + squareSideBC == squareSideAB;
            isRightTriangleData[i][1] = testTriangle[i];
        }
        return isRightTriangleData;
    }

    @DataProvider
    public Object[][] isAcuteTriangleData() {

        Object[][] isAcuteTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isAcuteTriangleData[i][0] = squareSideAB + squareSideAC > squareSideBC &&
                    squareSideAB + squareSideBC > squareSideAC &&
                    squareSideAC + squareSideBC > squareSideAB;
            isAcuteTriangleData[i][1] = testTriangle[i];
        }
        return isAcuteTriangleData;
    }

    @DataProvider
    public Object[][] isObtuseTriangleData() {

        Object[][] isObtuseTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isObtuseTriangleData[i][0] = squareSideAB + squareSideAC < squareSideBC ||
                    squareSideAB + squareSideBC < squareSideAC ||
                    squareSideAC + squareSideBC < squareSideAB;
            isObtuseTriangleData[i][1] = testTriangle[i];
        }
        return isObtuseTriangleData;
    }

    @Test(dataProvider = "isTriangleData")
    public void testIsTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isEquilateralTriangleData")
    public void testIsEquilateralTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isEquilateralTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isIsoscelesTriangleData")
    public void testIsIsoscelesTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isIsoscelesTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isRightTriangleData")
    public void testisRightTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isRightTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isAcuteTriangleData")
    public void testisAcuteTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isAcuteTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isObtuseTriangleData")
    public void testisObtuseTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isObtuseTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsEquilateralTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isEquilateralTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsEquilateralTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isEquilateralTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfIsEquilateralTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CheckOfTriangle.isEquilateralTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsIsoscelesTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isIsoscelesTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsIsoscelesTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isIsoscelesTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfIsIsoscelesTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CheckOfTriangle.isIsoscelesTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsRightTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isRightTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsRightTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isRightTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfIsRightTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CheckOfTriangle.isRightTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsAcuteTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isAcuteTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsAcuteTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isAcuteTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfIsAcuteTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CheckOfTriangle.isAcuteTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testNullExceptionOfIsObtuseTriangle() throws Exception {
        Triangle triangle = null;
        CheckOfTriangle.isObtuseTriangle(triangle);
    }

    @Test(expectedExceptions = TriangleNullException.class)
    public void testApexNullExceptionOfIsObtuseTriangle() throws Exception {
        Point2D point2D = null;
        Triangle triangle = new Triangle(point2D, new Point2D(0, 1), new Point2D(1, 2));
        CheckOfTriangle.isObtuseTriangle(triangle);
    }

    @Test(expectedExceptions = NotTriangleException.class)
    public void testIsTriangleExceptionOfIsObtuseTriangle() throws Exception {
        Triangle triangle = new Triangle(new Point2D(0,0), new Point2D(0, 0),
                new Point2D(0, 0));
        CheckOfTriangle.isObtuseTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsObtuseTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CheckOfTriangle.isObtuseTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsAcuteTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CheckOfTriangle.isAcuteTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsEquilateralTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CheckOfTriangle.isEquilateralTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsIsoscelesTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CheckOfTriangle.isIsoscelesTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsRightTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(0, 1));
        CheckOfTriangle.isRightTriangle(triangle);
    }

    @Test(expectedExceptions = DoubleOutOfBoundException.class)
    public void testIsDoubleOutOfBoundExceptionOfIsTriangle() throws Exception {
        double abscissaA = Math.pow(1.23E308d, 2);
        double ordinataA = Math.pow(1.24E308d, 2);
        double abscissaB = Math.pow(1.25E308d, 2);
        double ordinataB = Math.pow(1.26E308d, 2);
        double abscissaC = Math.pow(1.27E308d, 2);
        double ordinataC = Math.pow(1.28E308d, 2);
        Triangle triangle = new Triangle(new Point2D(abscissaA,ordinataA), new Point2D(abscissaB, ordinataB),
                new Point2D(abscissaC, ordinataC));
        CheckOfTriangle.isTriangle(triangle);
    }
}

package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.CorrectDataMissingException;
import by.epam.dmitriysedin.task01.util.creation.CreatorImpl;
import by.epam.dmitriysedin.task01.util.parse.CoordinatesParser;
import by.epam.dmitriysedin.task01.util.validation.FormatOfInputDataValidation;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TriangleInitImpl implements Initialization {

    Triangle triangle;
    Point2D apexA;
    Point2D apexB;
    Point2D apexC;

    public TriangleInitImpl(Triangle triangle, Point2D apexA, Point2D apexB, Point2D apexC) {
        this.triangle = triangle;
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }

    public void init(){

        triangle.setApexA(apexA);
        triangle.setApexB(apexB);
        triangle.setApexC(apexC);
    }

    public Triangle[] init(String[] paramOfTriangle)throws CorrectDataMissingException {

        List<Triangle> triangles = new ArrayList<>();

        CreatorImpl creator = new CreatorImpl();

        int indexOfAbscissaA = 0;
        int indexOfOrdinateA = 1;
        int indexOfAbscissaB = 2;
        int indexOfOrdinateB = 3;
        int indexOfAbscissaC = 4;
        int indexOfOrdinateC = 5;

        for(int i = 0; i < paramOfTriangle.length; i++){

            String line = paramOfTriangle[i];

            Point2D apexA = creator.point2dCreate();
            Point2D apexB = creator.point2dCreate();
            Point2D apexC = creator.point2dCreate();
            Triangle triangle = creator.triangleCreate();

            if(new FormatOfInputDataValidation().isRightFormat(line)) {

                String[] coordinatesOfPoints = new CoordinatesParser().parse(line);

                new Point2DInitImpl(apexA, Double.parseDouble(coordinatesOfPoints[indexOfAbscissaA]),
                        Double.parseDouble(coordinatesOfPoints[indexOfOrdinateA])).init();

                new Point2DInitImpl(apexB, Double.parseDouble(coordinatesOfPoints[indexOfAbscissaB]),
                        Double.parseDouble(coordinatesOfPoints[indexOfOrdinateB])).init();

                new Point2DInitImpl(apexC, Double.parseDouble(coordinatesOfPoints[indexOfAbscissaC]),
                        Double.parseDouble(coordinatesOfPoints[indexOfOrdinateC])).init();

                new TriangleInitImpl(triangle, apexA, apexB, apexC).init();

                triangles.add(triangle);
            }
        }

        if(triangles.size() == 0){
            throw new CorrectDataMissingException("There is no correct data.");
        }

        Triangle[] trianglesArr = new Triangle[triangles.size()];

        return triangles.toArray(trianglesArr);
    }
}

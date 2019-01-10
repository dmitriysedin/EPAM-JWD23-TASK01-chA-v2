package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.Point2D;
import by.epam.dmitriysedin.task01.model.exception.*;
import by.epam.dmitriysedin.task01.util.creation.TriangleCreator;
import by.epam.dmitriysedin.task01.util.creation.Point2DCreator;
import by.epam.dmitriysedin.task01.util.parse.StringParser;
import by.epam.dmitriysedin.task01.util.read.ReadFromFile;
import by.epam.dmitriysedin.task01.util.validation.LineValidation;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TriangleInitFromFile {

    public static Triangle[] initFromFile(String fileName) throws EmptyFileException,
            ReadFromFileException, FileNotExistsException, TypeOfFileException, CorrectDataMissingException{

        String[] paramOfTriangle = ReadFromFile.readFromFile(fileName);

        List<Triangle> triangles = new ArrayList<>();

        int indexOfAbscissaA = 0;
        int indexOfOrdinateA = 1;
        int indexOfAbscissaB = 2;
        int indexOfOrdinateB = 3;
        int indexOfAbscissaC = 4;
        int indexOfOrdinateC = 5;

        for(int i = 0; i < paramOfTriangle.length; i++){

            String line = paramOfTriangle[i];

            Point2D apexA = Point2DCreator.create();
            Point2D apexB = Point2DCreator.create();
            Point2D apexC = Point2DCreator.create();
            Triangle triangle = TriangleCreator.create();

            if(LineValidation.getLineValidation(line)) {

                String[] valueOfPoints = StringParser.parse(line);

                Point2DInit.init(apexA, Double.parseDouble(valueOfPoints[indexOfAbscissaA]),
                        Double.parseDouble(valueOfPoints[indexOfOrdinateA]));

                Point2DInit.init(apexB, Double.parseDouble(valueOfPoints[indexOfAbscissaB]),
                        Double.parseDouble(valueOfPoints[indexOfOrdinateB]));

                Point2DInit.init(apexC, Double.parseDouble(valueOfPoints[indexOfAbscissaC]),
                        Double.parseDouble(valueOfPoints[indexOfOrdinateC]));

                TriangleInit.init(triangle, apexA, apexB, apexC);

                triangles.add(triangle);
            }
        }

        if(triangles.size() == 0){
            throw new CorrectDataMissingException("The file " + fileName + " has no correct data.");
        }
        Triangle[] trianglesArr = new Triangle[triangles.size()];

        return triangles.toArray(trianglesArr);
    }
}

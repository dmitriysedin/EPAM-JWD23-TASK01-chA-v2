package by.epam.dmitriysedin.task01.util.validation;

import by.epam.dmitriysedin.task01.util.parse.CoordinatesParser;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class FormatOfInputDataValidation {

    public boolean isRightFormat(String line){

        if(!isRightNumberOfValuesInLine(line)){
            return false;
        }

        String[] valueOfPoints = new CoordinatesParser().parse(line);

        for(String s : valueOfPoints){
            if(!isDouble(s)){
                return false;
            }
        }
        return true;
    }


    private static final int correctNumberOfValuesInLine = 6;

    private boolean isRightNumberOfValuesInLine(String line){

        return new CoordinatesParser().parse(line).length == correctNumberOfValuesInLine;
    }


    private boolean isDouble(String string){

        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

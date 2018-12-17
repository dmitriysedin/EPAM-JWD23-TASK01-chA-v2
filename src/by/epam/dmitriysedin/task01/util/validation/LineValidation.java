package by.epam.dmitriysedin.task01.util.validation;

import by.epam.dmitriysedin.task01.util.parse.StringParser;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class LineValidation {

    public static boolean getLineValidation(String line){

        if(!NumberOfValuesInLineValidation.getNumberOfValuesInLineValidation(line)){
            return false;
        }

        String[] valueOfPoints = StringParser.parse(line);

        for(String s : valueOfPoints){
            if(!DoubleValidation.getIsDoubleValidation(s)){
                return false;
            }
        }
        return true;
    }
}

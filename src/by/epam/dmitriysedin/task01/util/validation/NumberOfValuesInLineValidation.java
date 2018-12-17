package by.epam.dmitriysedin.task01.util.validation;

import by.epam.dmitriysedin.task01.util.parse.StringParser;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class NumberOfValuesInLineValidation {

    public static final int correctNumberOfValuesInLine = 6;

    public static final boolean getNumberOfValuesInLineValidation(String line){

        return StringParser.parse(line).length == correctNumberOfValuesInLine;
    }
}

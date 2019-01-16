package by.epam.dmitriysedin.task01.util.validation;

/**
 * Created by Dmitriy Sedin on 15.12.2018.
 */
public class OutputDataValidation {

    public boolean isDouble(double value){

        return value >= -Double.MAX_VALUE && value <= Double.MAX_VALUE;
    }

}

package by.epam.dmitriysedin.task01.util.validation;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class DoubleValidation {

    public static boolean getIsDoubleValidation(String string){

        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

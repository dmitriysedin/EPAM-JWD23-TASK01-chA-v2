package by.epam.dmitriysedin.task01.util.parse;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class CoordinatesParser implements Parser{

    public static final String SPLIT_REGEX = "\\s+";

    public String[] parse(String strings){

        return strings.split(SPLIT_REGEX);
    }
}

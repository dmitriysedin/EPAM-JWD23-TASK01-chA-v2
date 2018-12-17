package by.epam.dmitriysedin.task01.util.parse;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class StringParser {

    public static final String SPLIT_REGEX = "\\s+";

    public static String[] parse(String strings){

        return strings.split(SPLIT_REGEX);
    }
}

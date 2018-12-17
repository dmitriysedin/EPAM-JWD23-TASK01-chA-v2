package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 14.12.2018.
 */
public class CorrectDataMissingException extends Exception {

    private static final long serialVersionUID = -5277408082380526007L;

    public CorrectDataMissingException() {
    }

    public CorrectDataMissingException(String message) {
        super(message);
    }

    public CorrectDataMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CorrectDataMissingException(Throwable cause) {
        super(cause);
    }
}

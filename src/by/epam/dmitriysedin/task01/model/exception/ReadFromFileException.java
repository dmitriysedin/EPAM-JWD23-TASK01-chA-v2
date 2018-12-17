package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class ReadFromFileException extends Exception {

    private static final long serialVersionUID = 3684613376918544992L;

    public ReadFromFileException(String message) {
        super(message);
    }

    public ReadFromFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadFromFileException(Throwable cause) {
        super(cause);
    }

    public ReadFromFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ReadFromFileException() {
    }
}

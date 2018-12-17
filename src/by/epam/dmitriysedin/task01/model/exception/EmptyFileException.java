package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class EmptyFileException extends Exception {

    private static final long serialVersionUID = -8344248673025295733L;

    public EmptyFileException(String message) {
        super(message);
    }

    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFileException(Throwable cause) {
        super(cause);
    }

    public EmptyFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmptyFileException() {
    }
}

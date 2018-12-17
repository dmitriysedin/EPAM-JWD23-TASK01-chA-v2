package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 10.12.2018.
 */
public class NotTriangleException extends Exception {

    private static final long serialVersionUID = 1026733566950304590L;

    public NotTriangleException(String message) {
        super(message);
    }

    public NotTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotTriangleException(Throwable cause) {
        super(cause);
    }

    public NotTriangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotTriangleException() {
    }
}

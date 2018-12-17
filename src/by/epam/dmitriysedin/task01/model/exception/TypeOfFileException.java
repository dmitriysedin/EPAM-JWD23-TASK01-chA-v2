package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 07.12.2018.
 */
public class TypeOfFileException extends Exception {

    private static final long serialVersionUID = -396266558252740837L;

    public TypeOfFileException(String message) {
        super(message);
    }

    public TypeOfFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeOfFileException(Throwable cause) {
        super(cause);
    }

    public TypeOfFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TypeOfFileException() {
    }
}

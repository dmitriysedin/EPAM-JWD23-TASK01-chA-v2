package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 16.12.2018.
 */
public class DoubleOutOfBoundException extends Exception {

    private static final long serialVersionUID = 3892863663704117930L;

    public DoubleOutOfBoundException() {
    }

    public DoubleOutOfBoundException(String message) {
        super(message);
    }

    public DoubleOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleOutOfBoundException(Throwable cause) {
        super(cause);
    }
}

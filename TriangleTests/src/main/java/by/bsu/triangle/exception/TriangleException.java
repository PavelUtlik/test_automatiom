package by.bsu.triangle.exception;

public class TriangleException extends RuntimeException {

    private static final long serialVersionUID = -4899404863261061583L;

    public TriangleException() {
        super();
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }
}

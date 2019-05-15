package vn.edu.leading.shop.errors;

public class ValidatorException extends RuntimeException {
    private final String fieldName;

    public ValidatorException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public ValidatorException(String message, Throwable cause, String fieldName) {
        super(message, cause);
        this.fieldName = fieldName;
    }

    public ValidatorException(Throwable cause, String fieldName) {
        super(cause);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

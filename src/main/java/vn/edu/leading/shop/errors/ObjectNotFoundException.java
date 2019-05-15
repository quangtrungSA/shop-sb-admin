package vn.edu.leading.shop.errors;

public class ObjectNotFoundException extends ValidatorException {
    public ObjectNotFoundException(String fieldName) {
        super("objectNotFound", fieldName);
    }
}

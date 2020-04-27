package tetris.validation;

public class ObjectValidator {

    public static void ValidateObjectNotNull(Object object, String objectName) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " cannot be null.");
        }
    }

}
package tetris.validation;

public class DimensionsValidator {

    public static void ValidateDimensionsGreaterThanZero(int ...integers) {
        for (int integer : integers) {
            if (integer <= 0) {
                throw new IllegalArgumentException("Dimensions must be greater than zero.");
            }
        }
    }

}
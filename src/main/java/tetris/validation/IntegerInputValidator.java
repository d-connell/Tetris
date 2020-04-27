package tetris.validation;

public class IntegerInputValidator {

    public static void ValidateInputGreaterThanZero(int ...integers) {
        for (int integer : integers) {
            if (integer <= 0) {
                throw new IllegalArgumentException("Input must be greater than zero.");
            }
        }
    }

}
package tetris.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class IntegerInputValidatorTest {

    @Test
    void shouldPassToConfirmPositiveDimensionsAreValid() {
        Assertions.assertDoesNotThrow(this::attemptToValidatePositiveDimensions);
    }

    @Test
    void shouldThrowErrorWhenValidatingZeroDimensions() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToValidateZeroDimensions);
    }

    @Test
    void shouldThrowErrorWhenValidatingNegativeDimensions() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToValidateNegativeDimensions);
    }

    private void attemptToValidatePositiveDimensions() {
        IntegerInputValidator.ValidateInputGreaterThanZero(1, 1);
    }

    private void attemptToValidateZeroDimensions() {
        IntegerInputValidator.ValidateInputGreaterThanZero(0, 0);
    }

    private void attemptToValidateNegativeDimensions() {
        IntegerInputValidator.ValidateInputGreaterThanZero(-1, -1);
    }

}
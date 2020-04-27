package tetris.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ObjectValidatorTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNullParameterValidated() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToVerifyNullObject);
    }

    private void attemptToVerifyNullObject() {
        ObjectValidator.ValidateObjectNotNull(null, "null object");
    }

    @Test
    void shouldPassWhenStringValidated() {
        Assertions.assertDoesNotThrow(this::attemptToVerifyString);
    }

    private void attemptToVerifyString() {
        String string = "string";
        ObjectValidator.ValidateObjectNotNull(string, "string");
    }

}
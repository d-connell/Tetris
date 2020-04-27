package tetris.output.background;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TetrisBackgroundTest {

    @Test
    void shouldPassWhenCreatingBackgroundWithCorrectFileName() {
        Assertions.assertDoesNotThrow(this::attemptToCreateBackgroundWithCorrectFileName);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForIncorrectFileName() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToCreateBackgroundWithIncorrectFileName);
    }

    private Background attemptToCreateBackgroundWithCorrectFileName() {
        return new TetrisBackground("src/main/resources/background.png");
    }

    private void attemptToCreateBackgroundWithIncorrectFileName() {
        new TetrisBackground("src/main/resources/filename.png");
    }

}
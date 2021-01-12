package tetris.output.display;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.input.DefaultKeyboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


class WindowTest {

    @Test
    void shouldPassWhenWindowInstantiatedWithSpecifiedDimensions() {
        Window window = makeWindow(800, 600);
        assertEquals(800, window.getCanvas().getWidth());
        assertEquals(600, window.getCanvas().getHeight());
    }

    @Test
    void shouldThrowErrorWhenWindowInstantiatedWithZeroDimensions() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToMakeWindowWithZeroDimensions);
    }

    @Test
    void shouldThrowErrorWhenWindowInstantiatedWithNegativeDimensions() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToMakeWindowWithNegativeDimensions);
    }

    private Window makeWindow(int width, int height) {
        DefaultKeyboard mockKeyboard = mock(DefaultKeyboard.class);
        return new Window(width, height, "test", mockKeyboard);
    }

    private void attemptToMakeWindowWithZeroDimensions() {
        makeWindow(0, 0);
    }

    private void attemptToMakeWindowWithNegativeDimensions() {
        makeWindow(-800, -600);
    }

}
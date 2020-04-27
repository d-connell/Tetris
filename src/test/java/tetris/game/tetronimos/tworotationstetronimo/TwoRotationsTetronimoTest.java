package tetris.game.tetronimos.tworotationstetronimo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import tetris.game.tetronimos.Tetronimo;

class TwoRotationsTetronimoTest {

    @Test
    void shouldPassToConfirmTetronimoInFirstRotationRotatesFromFirstPositionWhenRotatingClockwise() {
        Tetronimo tetronimo = Mockito.mock(ZTetronimo.class);
        tetronimo.rotateClockwise();
//        Mockito.verify(tetronimo, times(1)).
    }

}
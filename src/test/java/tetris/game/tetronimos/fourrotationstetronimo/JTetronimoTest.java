package tetris.game.tetronimos.fourrotationstetronimo;

import org.junit.jupiter.api.Test;
import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class JTetronimoTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        JTetronimo tetronimo = createJTetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.BLUE, tetronimo.firstBlock.getColour());
        assertEquals(Colour.BLUE, tetronimo.secondBlock.getColour());
        assertEquals(Colour.BLUE, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.BLUE, tetronimo.fourthBlock.getColour());
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // Rotations in middle of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    // Rotations at top of grid

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFirstRotationAtTopOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFirstRotationAtTopOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // Rotations at left of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(-3, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFourthRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(-4,0);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(-3,2);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(2, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFourthRotationAtLeftOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(-4,0);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // Rotations at right of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(1,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromSecondRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(2,0);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(6, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(1,2);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromSecondRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(2,0);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(6, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // Rotations at bottom of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromThirdRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(0,3);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromThirdRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(0,3);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        JTetronimo tetronimo = createJTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    private JTetronimo createJTetronimo() {
        return new JTetronimo(new DefaultGrid(mockGameRenderer, 7, 6), mockGameRenderer);
    }

}
package tetris.game.tetronimos.fourrotationstetronimo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import tetris.game.DefaultTetris;
import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Rotation;
import tetris.input.DefaultKeyboard;
import tetris.output.Colour;
import tetris.output.gamerenderer.DefaultGameRenderer;
import tetris.output.gamerenderer.GameRenderer;

class LTetronimoTest {

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        LTetronimo tetronimo = createLTetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.ORANGE, tetronimo.firstBlock.getColour());
        assertEquals(Colour.ORANGE, tetronimo.secondBlock.getColour());
        assertEquals(Colour.ORANGE, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.ORANGE, tetronimo.fourthBlock.getColour());
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations in middle of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 3);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(3, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at top of grid

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFirstRotationAtTopOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFirstRotationAtTopOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at left of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(-3, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(2, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFourthRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0, 2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(-4,0);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(-3,2);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(-3,0);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFourthRotationAtLeftOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(-4,0);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at right of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(1,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromSecondRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(2,0);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(6, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(1,2);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromSecondRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(2,0);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(6, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at bottom of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(3, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromSecondRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromThirdRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(0,3);
        tetronimo.rotateClockwiseFromThirdRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFourthRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FOURTH_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateAntiClockwiseFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromThirdRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.tryToMove(0,3);
        tetronimo.rotateAntiClockwiseFromThirdRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        LTetronimo tetronimo = createLTetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateClockwiseFromFirstRotation();
        tetronimo.rotateClockwiseFromSecondRotation();
        tetronimo.rotateClockwiseFromThirdRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateAntiClockwiseFromFourthRotation();
        assertEquals(Rotation.THIRD_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    private LTetronimo createLTetronimo() {
        GameRenderer gameRenderer = new DefaultGameRenderer(7, 6, "test", new DefaultKeyboard(new DefaultTetris()));
        return new LTetronimo(new DefaultGrid(gameRenderer, 7, 6), gameRenderer);
    }

}
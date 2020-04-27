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

class TTetronimoTest {

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        TTetronimo tetronimo = createTTetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.PURPLE, tetronimo.firstBlock.getColour());
        assertEquals(Colour.PURPLE, tetronimo.secondBlock.getColour());
        assertEquals(Colour.PURPLE, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.PURPLE, tetronimo.fourthBlock.getColour());
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations in middle of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationInMiddleOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at top of grid

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFirstRotationAtTopOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
        tetronimo.rotateClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFirstRotationAtTopOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
        tetronimo.rotateAntiClockwiseFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at left of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromFourthRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromFourthRotationAtLeftOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at right of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromSecondRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromSecondRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromThirdRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtRightOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    // rotations at bottom of grid

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateClockwiseFromThirdRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFirstRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromSecondRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateAntiClockwiseFromThirdRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesAntiClockwiseCorrectlyFromFourthRotationAtBottomOfGrid() {
        TTetronimo tetronimo = createTTetronimo();
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
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    private TTetronimo createTTetronimo() {
        GameRenderer gameRenderer = new DefaultGameRenderer(7, 6, "test", new DefaultKeyboard(new DefaultTetris()));
        return new TTetronimo(new DefaultGrid(gameRenderer, 7, 6), gameRenderer);
    }

}
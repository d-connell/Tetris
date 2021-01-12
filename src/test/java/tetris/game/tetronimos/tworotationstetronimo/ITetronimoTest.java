package tetris.game.tetronimos.tworotationstetronimo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ITetronimoTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        ITetronimo tetronimo = createITetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.AQUA, tetronimo.firstBlock.getColour());
        assertEquals(Colour.AQUA, tetronimo.secondBlock.getColour());
        assertEquals(Colour.AQUA, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.AQUA, tetronimo.fourthBlock.getColour());
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(0, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromFirstRotationInMiddleOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(-1,2);
        tetronimo.rotateFromFirstRotation();
        Assertions.assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromSecondRotationInMiddleOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(-1,2);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromFirstRotationAtTopTwoRowsOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        tetronimo.tryToMove(0, 1);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstRotationAtLeftOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(-3,2);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(2, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(2, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromSecondRotationAtLeftOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateFromFirstRotation();
        tetronimo.tryToMove(-5,0);
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstPositionAtRightOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromSecondPositionAtRightOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateFromFirstRotation();
        tetronimo.tryToMove(1,0);
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(6, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(6, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(6, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(6, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromFirstRotationAtBottomOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(-1,5);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromSecondPositionAtBottomOfGrid() {
        ITetronimo tetronimo = createITetronimo();
        tetronimo.tryToMove(-1,2);
        tetronimo.rotateFromFirstRotation();
        tetronimo.tryToMove(0,2);
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    private ITetronimo createITetronimo() {
        return new ITetronimo(new DefaultGrid(mockGameRenderer,7,6), mockGameRenderer);
    }

}
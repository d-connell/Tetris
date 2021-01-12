package tetris.game.tetronimos.tworotationstetronimo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ZTetronimoTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        ZTetronimo tetronimo = createZTetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.RED, tetronimo.firstBlock.getColour());
        assertEquals(Colour.RED, tetronimo.secondBlock.getColour());
        assertEquals(Colour.RED, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.RED, tetronimo.fourthBlock.getColour());
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(0, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromFirstRotationInMiddleOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(-1,1);
        tetronimo.rotateFromFirstRotation();
        Assertions.assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(3, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromSecondRotationInMiddleOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(-1,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromFirstRotationAtTopOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstRotationAtLeftOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(-3,1);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(2, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromSecondRotationAtLeftOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.tryToMove(-4,1);
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(0, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(0, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstPositionAtRightOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromSecondPositionAtRightOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstRotationAtBottomOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(5, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(5, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromSecondPositionAtBottomOfGrid() {
        ZTetronimo tetronimo = createZTetronimo();
        tetronimo.tryToMove(0,4);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(4, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(5, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    private ZTetronimo createZTetronimo() {
        return new ZTetronimo(new DefaultGrid(mockGameRenderer,6,6), mockGameRenderer);
    }

}
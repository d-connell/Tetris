package tetris.game.tetronimos.tworotationstetronimo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class STetronimoTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    @Test
    void shouldPassToConfirmCreatedCorrectly() {
        STetronimo tetronimo = createSTetronimo();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(Colour.GREEN, tetronimo.firstBlock.getColour());
        assertEquals(Colour.GREEN, tetronimo.secondBlock.getColour());
        assertEquals(Colour.GREEN, tetronimo.thirdBlock.getColour());
        assertEquals(Colour.GREEN, tetronimo.fourthBlock.getColour());
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(0, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(0, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromFirstRotationInMiddleOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(-1,1);
        tetronimo.rotateFromFirstRotation();
        Assertions.assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmRotatesCorrectlyFromSecondRotationInMiddleOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(-1,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromFirstRotationAtTopOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstRotationAtLeftOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(-3,1);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(1, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(1, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(2, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(2, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCannotRotateFromSecondRotationAtLeftOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.tryToMove(-4,1);
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(0, tetronimo.firstBlock.getXPosition());
        assertEquals(1, tetronimo.firstBlock.getYPosition());
        assertEquals(0, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(1, tetronimo.thirdBlock.getXPosition());
        assertEquals(2, tetronimo.thirdBlock.getYPosition());
        assertEquals(1, tetronimo.fourthBlock.getXPosition());
        assertEquals(3, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstPositionAtRightOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(4, tetronimo.firstBlock.getXPosition());
        assertEquals(0, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(1, tetronimo.secondBlock.getYPosition());
        assertEquals(5, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(2, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromSecondPositionAtRightOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(0,1);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(2, tetronimo.firstBlock.getYPosition());
        assertEquals(4, tetronimo.secondBlock.getXPosition());
        assertEquals(2, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(1, tetronimo.thirdBlock.getYPosition());
        assertEquals(5, tetronimo.fourthBlock.getXPosition());
        assertEquals(1, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromFirstRotationAtBottomOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(-1,4);
        tetronimo.rotateFromFirstRotation();
        assertEquals(Rotation.SECOND_ROTATION, tetronimo.currentRotation);
        assertEquals(3, tetronimo.firstBlock.getXPosition());
        assertEquals(3, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(4, tetronimo.secondBlock.getYPosition());
        assertEquals(4, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(5, tetronimo.fourthBlock.getYPosition());
    }

    @Test
    void shouldPassToConfirmCanRotateFromSecondPositionAtBottomOfGrid() {
        STetronimo tetronimo = createSTetronimo();
        tetronimo.tryToMove(-1,4);
        tetronimo.rotateFromFirstRotation();
        tetronimo.rotateFromSecondRotation();
        assertEquals(Rotation.FIRST_ROTATION, tetronimo.currentRotation);
        assertEquals(2, tetronimo.firstBlock.getXPosition());
        assertEquals(5, tetronimo.firstBlock.getYPosition());
        assertEquals(3, tetronimo.secondBlock.getXPosition());
        assertEquals(5, tetronimo.secondBlock.getYPosition());
        assertEquals(3, tetronimo.thirdBlock.getXPosition());
        assertEquals(4, tetronimo.thirdBlock.getYPosition());
        assertEquals(4, tetronimo.fourthBlock.getXPosition());
        assertEquals(4, tetronimo.fourthBlock.getYPosition());
    }

    private STetronimo createSTetronimo() {
        return new STetronimo(new DefaultGrid(mockGameRenderer,6,6), mockGameRenderer);
    }

}
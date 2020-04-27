package tetris.game.tetronimos.tworotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public class ZTetronimo extends TwoRotationsTetronimo {

    private static final Colour colour = Colour.RED;
    private static final int firstBlockXPosition = 3;
    private static final int firstBlockYPosition = 0;
    private static final int secondBlockXPosition = 4;
    private static final int secondBlockYPosition = 0;
    private static final int thirdBlockXPosition = 4;
    private static final int thirdBlockYPosition = 1;
    private static final int fourthBlockXPosition = 5;
    private static final int fourthBlockYPosition = 1;

    public ZTetronimo(Grid grid, GameRenderer gameRenderer) {
        super(grid, gameRenderer, colour,
                firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition,
                thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    void rotateFromFirstRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 2, -1);
        checkNewPosition(secondBlock, 1, 0);
        checkNewPosition(thirdBlock, 0, -1);
        checkNewPosition(fourthBlock, -1, 0);
        if (canMove) {
            firstBlock.updatePosition(2, -1);
            secondBlock.updatePosition(1, 0);
            thirdBlock.updatePosition(0, -1);
            fourthBlock.updatePosition(-1, 0);
            currentRotation = Rotation.SECOND_ROTATION;
        }
    }

    void rotateFromSecondRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -2, 1);
        checkNewPosition(secondBlock, -1, 0);
        checkNewPosition(thirdBlock, 0, 1);
        checkNewPosition(fourthBlock, 1, 0);
        if (canMove) {
            firstBlock.updatePosition(-2, 1);
            secondBlock.updatePosition(-1, 0);
            thirdBlock.updatePosition(0, 1);
            fourthBlock.updatePosition(1, 0);
            currentRotation = Rotation.FIRST_ROTATION;
        }
    }

}
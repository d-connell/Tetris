package tetris.game.tetronimos.tworotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public class STetronimoTetronimo extends TwoRotationsTetronimo {

    private static final Colour colour = Colour.GREEN;
    private static final int firstBlockXPosition = 3;
    private static final int firstBlockYPosition = 1;
    private static final int secondBlockXPosition = 4;
    private static final int secondBlockYPosition = 1;
    private static final int thirdBlockXPosition = 4;
    private static final int thirdBlockYPosition = 0;
    private static final int fourthBlockXPosition = 5;
    private static final int fourthBlockYPosition = 0;

    public STetronimoTetronimo(Grid grid, GameRenderer gameRenderer) {
        super(grid, gameRenderer, colour,
                firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition,
                thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    void rotateFromFirstRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 1, -2);
        checkNewPosition(secondBlock, 0, -1);
        checkNewPosition(thirdBlock, 1, 0);
        checkNewPosition(fourthBlock, 0, 1);
        if (canMove) {
            firstBlock.updatePosition(1, -2);
            secondBlock.updatePosition(0, -1);
            thirdBlock.updatePosition(1, 0);
            fourthBlock.updatePosition(0, 1);
            currentRotation = Rotation.SECOND_ROTATION;
        }
    }

    void rotateFromSecondRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -1, 2);
        checkNewPosition(secondBlock, 0, 1);
        checkNewPosition(thirdBlock, -1, 0);
        checkNewPosition(fourthBlock, 0, -1);
        if (canMove) {
            firstBlock.updatePosition(-1, 2);
            secondBlock.updatePosition(0, 1);
            thirdBlock.updatePosition(-1, 0);
            fourthBlock.updatePosition(0, -1);
            currentRotation = Rotation.FIRST_ROTATION;
        }
    }

}
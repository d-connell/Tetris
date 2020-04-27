package tetris.game.tetronimos.tworotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public class ITetronimo extends TwoRotationsTetronimo {

    private static final Colour colour = Colour.AQUA;
    private static final int firstBlockXPosition = 3;
    private static final int firstBlockYPosition = 0;
    private static final int secondBlockXPosition = 4;
    private static final int secondBlockYPosition = 0;
    private static final int thirdBlockXPosition = 5;
    private static final int thirdBlockYPosition = 0;
    private static final int fourthBlockXPosition = 6;
    private static final int fourthBlockYPosition = 0;

    public ITetronimo(Grid grid, GameRenderer gameRenderer) {
        super(grid, gameRenderer, colour,
                firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition,
                thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    void rotateFromFirstRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 2, -2);
        checkNewPosition(secondBlock, 1, -1);
        checkNewPosition(fourthBlock, -1, 1);
        if (canMove) {
            firstBlock.updatePosition(2,-2);
            secondBlock.updatePosition(1, -1);
            fourthBlock.updatePosition(-1, 1);
            currentRotation = Rotation.SECOND_ROTATION;
        }
    }

    void rotateFromSecondRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -2, 2);
        checkNewPosition(secondBlock, -1, 1);
        checkNewPosition(fourthBlock, 1, -1);
        if (canMove) {
            firstBlock.updatePosition(-2,2);
            secondBlock.updatePosition(-1, 1);
            fourthBlock.updatePosition(1, -1);
            currentRotation = Rotation.FIRST_ROTATION;
        }
    }

}
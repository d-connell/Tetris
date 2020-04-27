package tetris.game.tetronimos.fourrotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public class TTetronimo extends FourRotationsTetronimo {

    private static final Colour colour = Colour.PURPLE;
    private static final int firstBlockXPosition = 3;
    private static final int firstBlockYPosition = 0;
    private static final int secondBlockXPosition = 4;
    private static final int secondBlockYPosition = 0;
    private static final int thirdBlockXPosition = 5;
    private static final int thirdBlockYPosition = 0;
    private static final int fourthBlockXPosition = 4;
    private static final int fourthBlockYPosition = 1;

    public TTetronimo(Grid grid, GameRenderer gameRenderer) {
        super(grid, gameRenderer, colour,
                firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition,
                thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    @Override
    public void rotateClockwiseFromFirstRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 1, -1);
        checkNewPosition(thirdBlock, -1, 1);
        checkNewPosition(fourthBlock, -1, -1);
        if (canMove) {
            firstBlock.updatePosition(1, -1);
            thirdBlock.updatePosition(-1, 1);
            fourthBlock.updatePosition(-1, -1);
            currentRotation = Rotation.SECOND_ROTATION;
        }
    }

    @Override
    public void rotateClockwiseFromSecondRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 1, 1);
        checkNewPosition(thirdBlock, -1, -1);
        checkNewPosition(fourthBlock, 1, -1);
        if (canMove) {
            firstBlock.updatePosition(1, 1);
            thirdBlock.updatePosition(-1, -1);
            fourthBlock.updatePosition(1, -1);
            currentRotation = Rotation.THIRD_ROTATION;
        }
    }

    @Override
    public void rotateClockwiseFromThirdRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -1, 1);
        checkNewPosition(thirdBlock, 1, -1);
        checkNewPosition(fourthBlock, 1, 1);
        if (canMove) {
            firstBlock.updatePosition(-1, 1);
            thirdBlock.updatePosition(1, -1);
            fourthBlock.updatePosition(1, 1);
            currentRotation = Rotation.FOURTH_ROTATION;
        }
    }

    @Override
    public void rotateClockwiseFromFourthRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -1, -1);
        checkNewPosition(thirdBlock, 1, 1);
        checkNewPosition(fourthBlock, -1, 1);
        if (canMove) {
            firstBlock.updatePosition(-1, -1);
            thirdBlock.updatePosition(1, 1);
            fourthBlock.updatePosition(-1, 1);
            currentRotation = Rotation.FIRST_ROTATION;
        }
    }

    @Override
    public void rotateAntiClockwiseFromFirstRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 1, 1);
        checkNewPosition(thirdBlock, -1, -1);
        checkNewPosition(fourthBlock, 1, -1);
        if (canMove) {
            firstBlock.updatePosition(1, 1);
            thirdBlock.updatePosition(-1, -1);
            fourthBlock.updatePosition(1, -1);
            currentRotation = Rotation.FOURTH_ROTATION;
        }
    }

    @Override
    public void rotateAntiClockwiseFromSecondRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -1, 1);
        checkNewPosition(thirdBlock, 1, -1);
        checkNewPosition(fourthBlock, 1, 1);
        if (canMove) {
            firstBlock.updatePosition(-1, 1);
            thirdBlock.updatePosition(1, -1);
            fourthBlock.updatePosition(1, 1);
            currentRotation = Rotation.FIRST_ROTATION;
        }
    }

    @Override
    public void rotateAntiClockwiseFromThirdRotation() {
        canMove = true;
        checkNewPosition(firstBlock, -1, -1);
        checkNewPosition(thirdBlock, 1, 1);
        checkNewPosition(fourthBlock, -1, 1);
        if (canMove) {
            firstBlock.updatePosition(-1, -1);
            thirdBlock.updatePosition(1, 1);
            fourthBlock.updatePosition(-1, 1);
            currentRotation = Rotation.SECOND_ROTATION;
        }
    }

    @Override
    public void rotateAntiClockwiseFromFourthRotation() {
        canMove = true;
        checkNewPosition(firstBlock, 1, -1);
        checkNewPosition(thirdBlock, -1, 1);
        checkNewPosition(fourthBlock, -1, -1);
        if (canMove) {
            firstBlock.updatePosition(1, -1);
            thirdBlock.updatePosition(-1, 1);
            fourthBlock.updatePosition(-1, -1);
            currentRotation = Rotation.THIRD_ROTATION;
        }
    }

}
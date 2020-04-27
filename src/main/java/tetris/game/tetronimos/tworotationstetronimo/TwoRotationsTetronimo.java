package tetris.game.tetronimos.tworotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.AbstractTetronimo;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public abstract class TwoRotationsTetronimo extends AbstractTetronimo {

    Rotation currentRotation = Rotation.FIRST_ROTATION;

    public TwoRotationsTetronimo(Grid grid, GameRenderer gameRenderer, Colour colour,
                                 int firstBlockXPosition, int firstBlockYPosition, int secondBlockXPosition, int secondBlockYPosition,
                                 int thirdBlockXPosition, int thirdBlockYPosition, int fourthBlockXPosition, int fourthBlockYPosition) {
        super(grid, gameRenderer, colour, firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition, thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    @Override
    public void rotateClockwise() {
        switch (currentRotation) {
            case FIRST_ROTATION:
                rotateFromFirstRotation();
                break;
            case SECOND_ROTATION:
                rotateFromSecondRotation();
                break;
            default:
                break;
        }
    }

    @Override
    public void rotateAntiClockwise() {
        rotateClockwise();
    }

    abstract void rotateFromFirstRotation();

    abstract void rotateFromSecondRotation();

}
package tetris.game.tetronimos.fourrotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.AbstractTetronimo;
import tetris.game.tetronimos.Rotation;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public abstract class FourRotationsTetronimo extends AbstractTetronimo {

    Rotation currentRotation = Rotation.FIRST_ROTATION;

    public FourRotationsTetronimo(Grid grid, GameRenderer gameRenderer, Colour colour,
                                  int firstBlockXPosition, int firstBlockYPosition, int secondBlockXPosition, int secondBlockYPosition,
                                  int thirdBlockXPosition, int thirdBlockYPosition, int fourthBlockXPosition, int fourthBlockYPosition) {
        super(grid, gameRenderer, colour, firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition, thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

    @Override
    public void rotateClockwise() {
        switch (currentRotation) {
            case FIRST_ROTATION:
                rotateClockwiseFromFirstRotation();
                break;
            case SECOND_ROTATION:
                rotateClockwiseFromSecondRotation();
                break;
            case THIRD_ROTATION:
                rotateClockwiseFromThirdRotation();
                break;
            case FOURTH_ROTATION:
                rotateClockwiseFromFourthRotation();
                break;
            default:
                break;
        }
    }

    @Override
    public void rotateAntiClockwise() {
        switch (currentRotation) {
            case FIRST_ROTATION:
                rotateAntiClockwiseFromFirstRotation();
                break;
            case SECOND_ROTATION:
                rotateAntiClockwiseFromSecondRotation();
                break;
            case THIRD_ROTATION:
                rotateAntiClockwiseFromThirdRotation();
                break;
            case FOURTH_ROTATION:
                rotateAntiClockwiseFromFourthRotation();
                break;
            default:
                break;
        }
    }

    abstract void rotateClockwiseFromFirstRotation();

    abstract void rotateClockwiseFromSecondRotation();

    abstract void rotateClockwiseFromThirdRotation();

    abstract void rotateClockwiseFromFourthRotation();

    abstract void rotateAntiClockwiseFromFirstRotation();

    abstract void rotateAntiClockwiseFromSecondRotation();

    abstract void rotateAntiClockwiseFromThirdRotation();

    abstract void rotateAntiClockwiseFromFourthRotation();

}
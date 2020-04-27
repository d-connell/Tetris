package tetris.game.tetronimos.norotationstetronimo;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.AbstractTetronimo;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

public class OTetronimo extends AbstractTetronimo {

    private static final Colour colour = Colour.YELLOW;
    private static final int firstBlockXPosition = 4;
    private static final int firstBlockYPosition = 0;
    private static final int secondBlockXPosition = 5;
    private static final int secondBlockYPosition = 0;
    private static final int thirdBlockXPosition = 4;
    private static final int thirdBlockYPosition = 1;
    private static final int fourthBlockXPosition = 5;
    private static final int fourthBlockYPosition = 1;

    public OTetronimo(Grid grid, GameRenderer gameRenderer) {
        super(grid, gameRenderer, colour,
                firstBlockXPosition, firstBlockYPosition, secondBlockXPosition, secondBlockYPosition,
                thirdBlockXPosition, thirdBlockYPosition, fourthBlockXPosition, fourthBlockYPosition);
    }

}
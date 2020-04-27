package tetris.game.grid.cell;

import tetris.output.Colour;

public interface Cell {

    void fixBlock(Colour colour);

    boolean getIsOccupied();

    Colour getColour();

}
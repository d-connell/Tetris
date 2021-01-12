package tetris.game.grid.cell;

import tetris.output.Colour;

public interface Cell {

    void fixBlock(Colour colour);

    boolean isOccupied();

    Colour getColour();

}
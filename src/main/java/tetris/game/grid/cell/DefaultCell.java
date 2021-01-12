package tetris.game.grid.cell;

import tetris.output.Colour;
import tetris.validation.ObjectValidator;

public class DefaultCell implements Cell {

    private boolean isOccupied;
    private Colour colour;

    public DefaultCell() {
        isOccupied = false;
    }

    @Override
    public void fixBlock(Colour colour) {
        ObjectValidator.ValidateObjectNotNull(colour, "colour");
        this.isOccupied = true;
        this.colour = colour;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

}
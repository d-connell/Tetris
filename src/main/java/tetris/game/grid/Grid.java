package tetris.game.grid;

import tetris.game.grid.cell.Cell;
import tetris.game.tetronimos.block.Block;

public interface Grid {

    void fixBlock(Block Block);

    int checkForCompletedRows();

    Cell[][] getCells();

    int getBlocksWide();

    int getBlocksHigh();

    boolean isEmpty();

}
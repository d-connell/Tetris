package tetris.game.grid;

import tetris.game.grid.cell.Cell;
import tetris.game.grid.cell.DefaultCell;
import tetris.game.tetronimos.block.Block;
import tetris.output.gamerenderer.GameRenderer;
import tetris.output.itemrenderers.DefaultGridRenderer;
import tetris.validation.ObjectValidator;

import java.util.concurrent.atomic.AtomicInteger;

public class DefaultGrid implements Grid {

    private Cell[][] cells;
    private final int blocksWide;
    private final int blocksHigh;
    private boolean isEmpty;

    public DefaultGrid(GameRenderer gameRenderer, int blocksWide, int blocksHigh) {
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        this.blocksWide = blocksWide;
        this.blocksHigh = blocksHigh;
        new DefaultGridRenderer(gameRenderer, this);
        makeCells();
    }

    @Override
    public void fixBlock(Block block) {
        ObjectValidator.ValidateObjectNotNull(block, "block");
        cells[block.getYPosition()][block.getXPosition()].fixBlock(block.getColour());
    }

    @Override
    public int checkForCompletedRows() {
        AtomicInteger completedRows = new AtomicInteger();
        for (AtomicInteger verticalPosition = new AtomicInteger(blocksHigh - 1); verticalPosition.get() >= 0; verticalPosition.getAndDecrement()) {
            if (isRowComplete(verticalPosition.get())) {
                deleteRow(verticalPosition.get());
                completedRows.getAndIncrement();
                verticalPosition.getAndIncrement();
            }
        }
        checkIfGridEmpty();
        return completedRows.get();
    }

    @Override
    public Cell[][] getCells() {
        return cells;
    }

    @Override
    public int getBlocksWide() {
        return blocksWide;
    }

    @Override
    public int getBlocksHigh() {
        return blocksHigh;
    }

    @Override
    public boolean getIsEmpty() {
        return isEmpty;
    }

    private void makeCells() {
        cells = new Cell[blocksHigh][blocksWide];
        for (int verticalPosition = 0; verticalPosition < blocksHigh; verticalPosition++) {
            for (int horizontalPosition = 0; horizontalPosition < blocksWide; horizontalPosition++) {
                cells[verticalPosition][horizontalPosition] = new DefaultCell();
            }
        }
    }

    boolean isRowComplete(int verticalPosition) {
        for (int horizontalPosition = 0; horizontalPosition < blocksWide; horizontalPosition++) {
            if (!cells[verticalPosition][horizontalPosition].getIsOccupied()) {
                return false;
            }
        }
        return true;
    }

    protected void deleteRow(int rowNumber) {
        moveHigherRowsDown(rowNumber);
        makeNewTopRow();
    }

    protected void moveHigherRowsDown(int row) {
        for (int verticalPosition = row; verticalPosition > 0; verticalPosition--) {
            System.arraycopy(cells[verticalPosition - 1], 0, cells[verticalPosition], 0, blocksWide);
        }
    }

    protected void makeNewTopRow() {
        for (int horizontalPosition = 0; horizontalPosition < blocksWide; horizontalPosition++) {
            cells[0][horizontalPosition] = new DefaultCell();
        }
    }

    void checkIfGridEmpty() {
        isEmpty = true;
        for (int verticalPosition = blocksHigh - 1; verticalPosition >= 0; verticalPosition--) {
            for (int horizontalPosition = 0; horizontalPosition < blocksWide; horizontalPosition++) {
                if (cells[verticalPosition][horizontalPosition].getIsOccupied()) {
                    isEmpty = false;
                    return;
                }
            }
        }
    }

}
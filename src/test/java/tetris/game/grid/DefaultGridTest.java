package tetris.game.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tetris.game.tetronimos.block.Block;
import tetris.game.tetronimos.block.DefaultBlock;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DefaultGridTest {

    GameRenderer mockGameRenderer = mock(GameRenderer.class);

    // Tests for cells changing colour when blocks fixed in grid

    @Test
    void shouldPassWhenCheckingCellWhichReceivedGreenBlockIsNowGreen() {
        DefaultGrid grid = createTwoByTwoGridWithSingleGreenCellInTopLeft();
        assertEquals(Colour.GREEN, grid.getCells()[0][0].getColour());
    }

    @Test
    void shouldPassCheckingCellsWhichDoNotReceiveABlockHaveNullColour() {
        DefaultGrid grid = createTwoByTwoGridWithSingleGreenCellInTopLeft();
        assertNull(grid.getCells()[0][1].getColour());
        assertNull(grid.getCells()[1][0].getColour());
        assertNull(grid.getCells()[1][1].getColour());
    }

    @Test
    void shouldPassWhenCheckingCellWhichReceivedGreenBlockIsNowBlue() {
        DefaultGrid grid = createTwoByTwoGridWithSingleGreenCellInTopLeft();
        assertNotEquals(Colour.BLUE, grid.getCells()[0][0].getColour());
    }

    // Tests for identifying completed rows

    @Test
    void shouldPassWhenGridHasOneCompleteRow() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        assertEquals(1, grid.checkForCompletedRows());
    }

    @Test
    void shouldPassWhenCheckingWhetherIndividualRowsAreComplete() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        assertFalse(grid.isRowComplete(0));
        assertFalse(grid.isRowComplete(1));
        assertTrue(grid.isRowComplete(2));
    }

    @Test
    void shouldThrowErrorWhenTryingToCheckARowOutsideTheGridIsComplete() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, this::attemptToCheckCompletenessForARowThatDoesntExist);
    }

    // Tests for deleting rows

    @Test
    void shouldPassWhenDeletingTheOnlyCompletedRow() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        assertEquals(1, grid.checkForCompletedRows());
        grid.deleteRow(2);
        assertEquals(0, grid.checkForCompletedRows());
    }

    @Test
    void shouldThrowErrorWhenTryingToDeleteARowOutsideTheGrid() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, ()->grid.deleteRow(3));
    }

    // Tests for moving higher rows down

    @Test
    void shouldPassWhenCopyingHigherRowsFromBottomRowWithBottomRowComplete() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        assertTrue(grid.isRowComplete(2));
        grid.moveHigherRowsDown(2);
        assertFalse(grid.isRowComplete(2));
    }

    @Test
    void shouldPassWhenCopyingHigherRowsFromMiddleRowWithBottomRowComplete() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        assertTrue(grid.isRowComplete(2));
        grid.moveHigherRowsDown(1);
        assertTrue(grid.isRowComplete(2));
    }

    @Test
    void shouldThrowErrorWhenTryingToCopyFromARowThatDoesntExist() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, this::attemptToCopyFromARowThatDoesNotExist);
    }

    // Tests for making a new top row

    @Test
    void shouldPassWhenReplacingTopRowWithNewCells() {
        DefaultGrid grid = createTwoByFiveGridWithCompleteTopRow();
        assertTrue(grid.isRowComplete(0));
        grid.makeNewTopRow();
        assertFalse(grid.isRowComplete(0));
    }

    // Tests for checking if the grid is empty

    @Test
    void shouldPassToConfirmEmptyGridIsEmpty() {
        DefaultGrid grid = createEmptyFiveByFiveGrid();
        grid.checkIfGridEmpty();
        assertTrue(grid.isEmpty());
    }

    @Test
    void shouldPassToConfirmPopulatedGridNotEmpty() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        grid.checkIfGridEmpty();
        assertFalse(grid.isEmpty());
    }

    @Test
    void shouldPassToConfirmGridWithSingleOccupiedCellNotEmpty() {
        DefaultGrid grid = createTwoByTwoGridWithSingleGreenCellInTopLeft();
        grid.checkIfGridEmpty();
        assertFalse(grid.isEmpty());
    }

    // Methods to support tests

    private DefaultGrid createTwoByTwoGridWithSingleGreenCellInTopLeft() {
        DefaultGrid grid = new DefaultGrid(mockGameRenderer,2,2);
        Block block = new DefaultBlock(mockGameRenderer, Colour.GREEN,0,0);
        grid.fixBlock(block);
        return grid;
    }

    private DefaultGrid createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow() {
        // The top row is empty, the middle row has one occupied cell, the bottom row is complete
        DefaultGrid grid = new DefaultGrid(mockGameRenderer,10,3);
        Block block = new DefaultBlock(mockGameRenderer, Colour.GREEN,1,1);
        grid.fixBlock(block);
        for (int i = 0; i < 10; i++) {
            block = new DefaultBlock(mockGameRenderer, Colour.GREEN,i,2);
            grid.fixBlock(block);
        }
        return grid;
    }

    private DefaultGrid createTwoByFiveGridWithCompleteTopRow() {
        DefaultGrid grid = new DefaultGrid(mockGameRenderer,10,3);
        for (int i = 0; i < 10; i++) {
            Block block = new DefaultBlock(mockGameRenderer, Colour.GREEN,i,0);
            grid.fixBlock(block);
        }
        return grid;
    }

    private DefaultGrid createEmptyFiveByFiveGrid() {
        return new DefaultGrid(mockGameRenderer,5,5);
    }

    private void attemptToCheckCompletenessForARowThatDoesntExist() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        grid.isRowComplete(3);
    }

    private void attemptToCopyFromARowThatDoesNotExist() {
        DefaultGrid grid = createThreeByTenGridWithOneEmptyRowOneCompleteRowAndOnePartiallyCompleteRow();
        grid.moveHigherRowsDown(3);
    }

}
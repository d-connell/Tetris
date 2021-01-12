package tetris.game.grid.cell;

import org.junit.jupiter.api.Test;
import tetris.output.Colour;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCellTest {

    @Test
    void shouldPassWhenCheckingGreenCellIsGreen() {
        Cell testCell = createGreenDefaultCell();
        assertEquals(Colour.GREEN, testCell.getColour());
    }

    @Test
    void shouldPassWhenCheckingGreenCellIsBlue() {
        Cell testCell = createGreenDefaultCell();
        assertNotEquals(Colour.BLUE, testCell.getColour());
    }

    @Test
    void shouldPassWhenCheckingEmptyCellHasNullColour() {
        Cell testCell = createEmptyDefaultCell();
        assertNull(testCell.getColour());
    }

    @Test
    void shouldPassWhenCheckingEmptyCellHasSomeColour() {
        Cell testCell = createEmptyDefaultCell();
        assertNotEquals(Colour.GREEN, testCell.getColour());
    }

    @Test
    void shouldPassWhenCheckingColouredCellIsOccupied() {
        Cell testCell = createGreenDefaultCell();
        assertTrue(testCell.isOccupied());
    }

    @Test
    void shouldPassWhenCheckingEmptyCellIsNotOccupied() {
        Cell testCell = createEmptyDefaultCell();
        assertFalse(testCell.isOccupied());
    }

    private Cell createGreenDefaultCell() {
        Cell cell = new DefaultCell();
        cell.fixBlock(Colour.GREEN);
        return cell;
    }

    private Cell createEmptyDefaultCell() {
        return new DefaultCell();
    }

}
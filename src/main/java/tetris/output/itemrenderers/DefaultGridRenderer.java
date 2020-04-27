package tetris.output.itemrenderers;

import tetris.game.grid.Grid;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;
import tetris.validation.ObjectValidator;

import java.awt.*;

public class DefaultGridRenderer implements ItemRenderer {

    private final GameRenderer gameRenderer;
    private final Grid grid;
    private final int gridBlocksWide;
    private final int gridBlocksHigh;
    private final int gridOutlineXCoordinate;
    private final int gridOutlineYCoordinate;
    private final int gridOutlineWidth;
    private final int gridOutlineHeight;
    private final int gridXCoordinate;
    private final int gridYCoordinate;
    private final int cellSize;

    public DefaultGridRenderer(GameRenderer gameRenderer, Grid grid) {
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        ObjectValidator.ValidateObjectNotNull(grid, "grid");
        this.gameRenderer = gameRenderer;
        this.grid = grid;
        this.gridBlocksWide = grid.getBlocksWide();
        this.gridBlocksHigh = grid.getBlocksHigh();
        this.gridOutlineXCoordinate = gameRenderer.getGridHorizontalCoordinate() - 1;
        this.gridOutlineYCoordinate = gameRenderer.getGridVerticalCoordinate() - 1;
        this.gridOutlineWidth = gridBlocksWide * gameRenderer.getBlockSize() + 2;
        this.gridOutlineHeight = gridBlocksHigh * gameRenderer.getBlockSize() + 2;
        this.gridXCoordinate = gameRenderer.getGridHorizontalCoordinate();
        this.gridYCoordinate = gameRenderer.getGridVerticalCoordinate();
        this.cellSize = gameRenderer.getBlockSize();
        gameRenderer.getRenderersToAdd().add(this);
    }

    @Override
    public void drawItem(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        drawOutline(graphics);
        if (gameRenderer.getIsPaused()) {
            drawAllCellsGrey(graphics);
        } else {
            drawOccupiedCells(graphics);
        }
    }

    private void drawOutline(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        graphics.setColor(Color.BLACK);
        graphics.fillRect(gridOutlineXCoordinate, gridOutlineYCoordinate, gridOutlineWidth, gridOutlineHeight);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(gridOutlineXCoordinate, gridOutlineYCoordinate, gridOutlineWidth, gridOutlineHeight);
    }

    private void drawAllCellsGrey(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        for (int verticalPosition = 0; verticalPosition < gridBlocksHigh; verticalPosition++) {
            for (int horizontalPosition = 0; horizontalPosition < gridBlocksWide; horizontalPosition++) {
                drawCell(horizontalPosition, verticalPosition, graphics, Colour.GREY);
            }
        }
    }

    private void drawOccupiedCells(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        for (int verticalPosition = 0; verticalPosition < gridBlocksHigh; verticalPosition++) {
            for (int horizontalPosition = 0; horizontalPosition < gridBlocksWide; horizontalPosition++) {
                if (grid.getCells()[verticalPosition][horizontalPosition].getIsOccupied()) {
                    drawCell(horizontalPosition, verticalPosition, graphics,
                            grid.getCells()[verticalPosition][horizontalPosition].getColour());
                }
            }
        }
    }

    private void drawCell(int horizontalPosition, int verticalPosition, Graphics graphics, Colour colour) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        ObjectValidator.ValidateObjectNotNull(colour, "colour");
        graphics.setColor(colour.getFillColour());
        graphics.fillRect(gridXCoordinate + horizontalPosition * cellSize,
                gridYCoordinate + verticalPosition * cellSize, cellSize, cellSize);
        graphics.setColor(colour.getBorderColour());
        graphics.drawRect(gridXCoordinate + horizontalPosition * cellSize,
                gridYCoordinate + verticalPosition * cellSize, cellSize, cellSize);
    }

}
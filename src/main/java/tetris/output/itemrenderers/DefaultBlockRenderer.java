package tetris.output.itemrenderers;

import tetris.game.tetronimos.block.Block;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;
import tetris.validation.ObjectValidator;

import java.awt.*;

public class DefaultBlockRenderer implements BlockRenderer {

    private final Block block;
    private final Colour colour;
    private boolean isInCurrentTetronimo;
    private int blockSize;
    private int gridHorizontalCoordinate;
    private int gridVerticalCoordinate;
    private int nextTetronimoHorizontalCoordinate;
    private int nextTetronimoVerticalCoordinate;

    public DefaultBlockRenderer(Block block, Colour colour, GameRenderer gameRenderer) {
        ObjectValidator.ValidateObjectNotNull(block, "block");
        ObjectValidator.ValidateObjectNotNull(colour, "colour");
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        this.block = block;
        this.colour = colour;
        this.isInCurrentTetronimo = false;
        setNumbers(gameRenderer);
        gameRenderer.getRenderersToAdd().add(this);
    }

    @Override
    public void drawItem(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int xPosition = block.getXPosition();
        int yPosition = block.getYPosition();
        int horizontalOffset = isInCurrentTetronimo ? gridHorizontalCoordinate : nextTetronimoHorizontalCoordinate;
        int verticalOffset = isInCurrentTetronimo ? gridVerticalCoordinate : nextTetronimoVerticalCoordinate;
        graphics.setColor(colour.getFillColour());
        graphics.fillRect(horizontalOffset + xPosition * blockSize, verticalOffset + yPosition * blockSize, blockSize, blockSize);
        graphics.setColor(colour.getBorderColour());
        graphics.drawRect(horizontalOffset + xPosition * blockSize, verticalOffset + yPosition * blockSize, blockSize, blockSize);
    }

    @Override
    public void setIsInCurrentTetronimo() {
        isInCurrentTetronimo = true;
    }

    private void setNumbers(GameRenderer gameRenderer) {
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        blockSize = gameRenderer.getBlockSize();
        gridHorizontalCoordinate = gameRenderer.getGridHorizontalCoordinate();
        gridVerticalCoordinate = gameRenderer.getGridVerticalCoordinate();
        nextTetronimoHorizontalCoordinate = gameRenderer.getDisplayWidth() * 3 / 4;
        nextTetronimoVerticalCoordinate = gameRenderer.getDisplayHeight() * 2 / 3;
    }

}
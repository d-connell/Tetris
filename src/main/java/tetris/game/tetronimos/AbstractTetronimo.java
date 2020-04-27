package tetris.game.tetronimos;

import tetris.game.grid.Grid;
import tetris.game.tetronimos.block.Block;
import tetris.game.tetronimos.block.DefaultBlock;
import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;
import tetris.validation.BlockPositionValidator;
import tetris.validation.ObjectValidator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractTetronimo implements Tetronimo {

    Grid grid;
    GameRenderer gameRenderer;
    int blocksWide;
    int blocksHigh;
    Collection<Block> blocks;
    public Block firstBlock;
    public Block secondBlock;
    public Block thirdBlock;
    public Block fourthBlock;
    boolean isFalling;
    protected boolean canMove;

    public AbstractTetronimo(Grid grid, GameRenderer gameRenderer, Colour colour,
                             int firstBlockXPosition, int firstBlockYPosition, int secondBlockXPosition, int secondBlockYPosition,
                             int thirdBlockXPosition, int thirdBlockYPosition, int fourthBlockXPosition, int fourthBlockYPosition) {
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        ObjectValidator.ValidateObjectNotNull(colour, "colour");
        this.grid = grid;
        this.gameRenderer = gameRenderer;
        this.blocksWide = grid.getBlocksWide();
        this.blocksHigh = grid.getBlocksHigh();
        this.blocks = new ArrayList<>();
        this.firstBlock = createBlock(colour, firstBlockXPosition, firstBlockYPosition);
        this.secondBlock = createBlock(colour, secondBlockXPosition, secondBlockYPosition);
        this.thirdBlock = createBlock(colour, thirdBlockXPosition, thirdBlockYPosition);
        this.fourthBlock = createBlock(colour, fourthBlockXPosition, fourthBlockYPosition);
        this.isFalling = true;
        BlockPositionValidator.validateBlocksHaveDistinctLocations(blocks);
    }

    @Override
    public void tryToMove(int xMove, int yMove) {
        canMove = true;
        for (Block block : blocks) {
            checkNewPosition(block, xMove, yMove);
            if (!canMove) {
                return;
            }
        }
        for (Block block : blocks) {
            block.updatePosition(xMove, yMove);
        }
    }

    @Override
    public boolean canFall() {
        tryToMove(0, 1);
        if (!canMove) {
            fixBlocksInGrid();
            removeIndividualRenderers();
            return false;
        }
        return true;
    }

    @Override
    public boolean isPlayable() {
        canMove = true;
        for (Block block : blocks) {
            checkNewPosition(block, 0, 0);
        }
        return canMove;
    }

    @Override
    public void moveToGrid() {
        for (Block block : blocks) {
            block.getRenderer().setIsInCurrentTetronimo();
        }
    }

    private Block createBlock(Colour colour, int firstBlockXPosition, int firstBlockYPosition) {
        Block block = new DefaultBlock(gameRenderer, colour, firstBlockXPosition, firstBlockYPosition);
        blocks.add(block);
        return block;
    }

    protected void checkNewPosition(Block block, int xMove, int yMove) {
        ObjectValidator.ValidateObjectNotNull(block, "block");
        if (block.getXPosition() + xMove < 0
                || block.getXPosition() + xMove >= blocksWide
                || block.getYPosition() + yMove < 0
                || block.getYPosition() + yMove >= blocksHigh
                || grid.getCells()[block.getYPosition() + yMove][block.getXPosition() + xMove].getIsOccupied()) {
            canMove = false;
        }
    }

    void fixBlocksInGrid() {
        for (Block block : blocks) {
            grid.fixBlock(block);
        }
    }

    void removeIndividualRenderers() {
        for (Block block : blocks) {
            gameRenderer.getRenderersToRemove().add(block.getRenderer());
        }
    }

}
package tetris.validation;


import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import tetris.game.DefaultTetris;
import tetris.output.gamerenderer.GameRenderer;
import tetris.game.tetronimos.block.Block;
import tetris.game.tetronimos.block.DefaultBlock;
import tetris.input.DefaultKeyboard;
import tetris.output.Colour;
import tetris.output.gamerenderer.DefaultGameRenderer;

class BlockPositionValidatorTest {

    @Test
    void shouldPassToConfirmTwoSeparateBlocksAreValid() {
        Assertions.assertDoesNotThrow(this::attemptToValidateTwoBlocksInSeparateLocations);
    }

    @Test
    void shouldPassToConfirmTwoAdjacentBlocksAreValid() {
        Assertions.assertDoesNotThrow(this::attemptToValidateTwoAdjacentBlocks);
    }

    @Test
    void shouldThrowErrorWhenCheckingTwoBlocksWithTheSameLocation() {
        Assertions.assertThrows(IllegalArgumentException.class, this::attemptToValidateTwoBlocksInTheSameLocation);
    }

    private void attemptToValidateTwoBlocksInSeparateLocations() {
        Collection<Block> blocks = makeTwoBlocks(3,3,5,5);
        BlockPositionValidator.validateBlocksHaveDistinctLocations(blocks);
    }

    private void attemptToValidateTwoAdjacentBlocks() {
        Collection<Block> blocks = makeTwoBlocks(4,4,4,5);
        BlockPositionValidator.validateBlocksHaveDistinctLocations(blocks);
    }

    private void attemptToValidateTwoBlocksInTheSameLocation() {
        Collection<Block> blocks = makeTwoBlocks(4,4,4,4);
        BlockPositionValidator.validateBlocksHaveDistinctLocations(blocks);
    }

    private Collection<Block> makeTwoBlocks(int firstHorizontalPosition, int firstVerticalPosition,
                                            int secondHorizontalPosition, int secondVerticalPosition) {
        GameRenderer gameRenderer = new DefaultGameRenderer(7, 6, "test", new DefaultKeyboard(new DefaultTetris()));
        Collection<Block> blocks = new ArrayList<>();
        Block firstBlock = new DefaultBlock(gameRenderer, Colour.AQUA, firstHorizontalPosition,firstVerticalPosition);
        blocks.add(firstBlock);
        Block secondBlock = new DefaultBlock(gameRenderer, Colour.AQUA, secondHorizontalPosition,secondVerticalPosition);
        blocks.add(secondBlock);
        return blocks;
    }

}
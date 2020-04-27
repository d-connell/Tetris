package tetris.validation;

import tetris.game.tetronimos.block.Block;

import java.util.Collection;

public class BlockPositionValidator {

    public static void validateBlocksHaveDistinctLocations(Collection<Block> blocks) {
        if (!allBlocksHaveDistinctLocations(blocks)) {
            throw new IllegalArgumentException("Blocks cannot be in the same positions.");
        }
    }

    private static boolean allBlocksHaveDistinctLocations(Collection<Block> blocks) {
        for (Block block: blocks) {
            for (Block anotherBlock: blocks) {
                if (block != anotherBlock
                        && block.getXPosition() == anotherBlock.getXPosition()
                        && block.getYPosition() == anotherBlock.getYPosition()) {
                    return false;
                }
            }
        }
        return true;
    }

}
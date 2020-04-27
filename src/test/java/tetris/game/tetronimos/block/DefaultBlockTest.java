package tetris.game.tetronimos.block;

import org.junit.jupiter.api.Test;

import tetris.game.DefaultTetris;
import tetris.input.DefaultKeyboard;
import tetris.output.Colour;
import tetris.output.gamerenderer.DefaultGameRenderer;
import tetris.output.gamerenderer.GameRenderer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultBlockTest {

    @Test
    void shouldPassToConfirmBlockCreatedWithSpecifiedParameters() {
        Block block = createGreenBlock();
        assertEquals(Colour.GREEN, block.getColour());
        assertEquals(2, block.getXPosition());
        assertEquals(3, block.getYPosition());
        assertNotNull(block.getRenderer());
    }

    @Test
    void shouldPassToConfirmBlockMovesWithSpecifiedPositiveDistanceAndDirection() {
        Block block = createGreenBlock();
        block.updatePosition(2, 2);
        assertEquals(4, block.getXPosition());
        assertEquals(5, block.getYPosition());
    }

    @Test
    void shouldPassToConfirmBlockMovesWithZeroDistanceAndDirection() {
        Block block = createGreenBlock();
        block.updatePosition(0, 0);
        assertEquals(2, block.getXPosition());
        assertEquals(3, block.getYPosition());
    }

    @Test
    void shouldPassToConfirmBlockMovesWithSpecifiedNegativeDistanceAndDirection() {
        Block block = createGreenBlock();
        block.updatePosition(-2, -2);
        assertEquals(0, block.getXPosition());
        assertEquals(1, block.getYPosition());
    }

    @Test
    void shouldPassToConfirmBlockMovesWithSpecifiedLargeNegativeDistanceAndDirection() {
        Block block = createGreenBlock();
        block.updatePosition(-4, -4);
        assertEquals(-2, block.getXPosition());
        assertEquals(-1, block.getYPosition());
    }

    private Block createGreenBlock() {
        GameRenderer gameRenderer = new DefaultGameRenderer(5, 5, "test", new DefaultKeyboard(new DefaultTetris()));
        return new DefaultBlock(gameRenderer, Colour.GREEN,2,3);
    }

}
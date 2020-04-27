package tetris.game.tetronimos.block;

import tetris.output.Colour;
import tetris.output.itemrenderers.BlockRenderer;

public interface Block {

    void updatePosition(int xMove, int yMove);

    int getXPosition();

    int getYPosition();

    BlockRenderer getRenderer();

    Colour getColour();

}
package tetris.game.tetronimos.block;

import tetris.output.Colour;
import tetris.output.gamerenderer.GameRenderer;
import tetris.output.itemrenderers.DefaultBlockRenderer;
import tetris.validation.ObjectValidator;

public class DefaultBlock implements Block {

    private final Colour colour;
    private int horizontalPosition;
    private int verticalPosition;
    private DefaultBlockRenderer renderer;

    public DefaultBlock(GameRenderer gameRenderer, Colour colour, int horizontalPosition, int verticalPosition) {
        ObjectValidator.ValidateObjectNotNull(gameRenderer, "gameRenderer");
        ObjectValidator.ValidateObjectNotNull(colour, "colour");
        this.colour = colour;
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        makeRenderer(gameRenderer);
    }

    @Override
    public void updatePosition(int horizontalMove, int verticalMove) {
        horizontalPosition += horizontalMove;
        verticalPosition += verticalMove;
    }

    @Override
    public int getXPosition() {
        return horizontalPosition;
    }

    @Override
    public int getYPosition() {
        return verticalPosition;
    }

    @Override
    public DefaultBlockRenderer getRenderer() {
        return renderer;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    private void makeRenderer(GameRenderer gameRenderer) {
        renderer = new DefaultBlockRenderer(this, colour, gameRenderer);
    }

}
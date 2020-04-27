package tetris.input;

import tetris.game.Game;
import tetris.validation.ObjectValidator;

public class DefaultKeyboard implements Keyboard {

    private final Game game;

    public DefaultKeyboard(Game game) {
        ObjectValidator.ValidateObjectNotNull(game, "game");
        this.game = game;
    }

    @Override
    public void keyPress(int keyCode) {
        game.processKeyCode(keyCode);
    }

}
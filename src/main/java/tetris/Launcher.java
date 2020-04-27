package tetris;

import tetris.game.DefaultTetris;
import tetris.game.Game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new DefaultTetris();
        game.start();
    }

}
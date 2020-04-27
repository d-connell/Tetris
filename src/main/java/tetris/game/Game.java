package tetris.game;

public interface Game {

    void start();

    void processKeyCode(int keyCode);

    void newGame();

    void quit();

}
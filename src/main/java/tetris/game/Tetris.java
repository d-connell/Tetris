package tetris.game;

public interface Tetris extends Game {

    void moveRight();

    void moveLeft();

    void rotateClockwise();

    void rotateAntiClockwise();

    void dropQuickly();

    void releaseTetronimo();

    void getNextTetronimo();

    void returnToMainScreen();

    void updateScore(int completedRows);

    void updateRowsCleared(int completedRows);

    void increaseLevel();

    void gameOver();

}
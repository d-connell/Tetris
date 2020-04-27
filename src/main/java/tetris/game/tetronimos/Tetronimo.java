package tetris.game.tetronimos;

public interface Tetronimo {

    void tryToMove(int xMove, int yMove);

    boolean canFall();

    boolean isPlayable();

    void moveToGrid();

    default void rotateClockwise() {
    }

    default void rotateAntiClockwise() {
    }

}
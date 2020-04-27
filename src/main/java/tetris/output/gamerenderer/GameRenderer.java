package tetris.output.gamerenderer;

import tetris.output.itemrenderers.ItemRenderer;

import java.util.Collection;

public interface GameRenderer {

    void updateDisplay(boolean isPaused, int rowsCleared, int level, int score, boolean isGameOver);

    Collection<ItemRenderer> getListOfRenderers();

    Collection<ItemRenderer> getRenderersToRemove();

    Collection<ItemRenderer> getRenderersToAdd();

    int getBlockSize();

    int getDisplayWidth();

    int getDisplayHeight();

    int getGridHorizontalCoordinate();

    int getGridVerticalCoordinate();

    boolean getIsPaused();

}
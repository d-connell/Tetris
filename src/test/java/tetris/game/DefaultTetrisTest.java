package tetris.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultTetrisTest {

    @Test
    void shouldPassToConfirmScoreIncreasesCorrectlyWithOneRowCompleteAtLevelZero() {
        DefaultTetris tetris = createTetrisAndIncreaseScore(1);
        assertEquals(1, tetris.score);
    }

    @Test
    void shouldPassToConfirmScoreIncreasesCorrectlyWithTwoRowsCompleteAtLevelZero() {
        DefaultTetris tetris = createTetrisAndIncreaseScore(2);
        assertEquals(2, tetris.score);
    }

    @Test
    void shouldPassToConfirmScoreIncreasesCorrectlyWithThreeRowsCompleteAtLevelZero() {
        DefaultTetris tetris = createTetrisAndIncreaseScore(3);
        assertEquals(4, tetris.score);
    }

    @Test
    void shouldPassToConfirmScoreIncreasesCorrectlyWithFourRowsCompleteAtLevelZero() {
        DefaultTetris tetris = createTetrisAndIncreaseScore(4);
        assertEquals(8, tetris.score);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfIncreasingScoreWithZeroRowsCleared() {
        Assertions.assertThrows(IllegalArgumentException.class, this::createTetrisAndIncrementScoreWithZeroRowsCleared);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfIncreasingScoreWithNegativeNumberOfRowsCleared() {
        Assertions.assertThrows(IllegalArgumentException.class, this::createTetrisAndIncrementScoreWithNegativeRowsCleared);
    }

    @Test
    void shouldPassToConfirmOneLevelIncreaseResultsInLevelOne() {
        DefaultTetris tetris = createTetrisAndIncreaseLevel(1);
        assertEquals(1, tetris.level);
    }

    @Test
    void shouldPassToConfirmOneLevelDoesNotIncreasePastLevelTen() {
        DefaultTetris tetris = createTetrisAndIncreaseLevel(11);
        assertEquals(10, tetris.level);
    }

    @Test
    void shouldPassToConfirmCompletingTenRowsIncreasesLevelByOne() {
        DefaultTetris tetris = createTetrisAndIncreaseCompletedRows(10);
        assertEquals(1, tetris.level);
    }

    private DefaultTetris createTetrisAndIncreaseScore(int rowsCleared) {
        DefaultTetris tetris = new DefaultTetris();
        tetris.newGame();
        tetris.updateScore(rowsCleared);
        return tetris;
    }

    private void createTetrisAndIncrementScoreWithZeroRowsCleared() {
        createTetrisAndIncreaseScore(0);
    }

    private void createTetrisAndIncrementScoreWithNegativeRowsCleared() {
        createTetrisAndIncreaseScore(-1);
    }

    private DefaultTetris createTetrisAndIncreaseLevel(int numberOfLevelIncreases) {
        DefaultTetris tetris = new DefaultTetris();
        for (int i = 1; i <= numberOfLevelIncreases; i++) {
            tetris.increaseLevel();
        }
        return tetris;
    }

    private DefaultTetris createTetrisAndIncreaseCompletedRows(int completedRows) {
        DefaultTetris tetris = new DefaultTetris();
        tetris.newGame();
        tetris.updateRowsCompleted(completedRows);
        return tetris;
    }

}
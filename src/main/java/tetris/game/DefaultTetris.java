package tetris.game;

import tetris.game.grid.DefaultGrid;
import tetris.game.tetronimos.Tetronimo;
import tetris.game.tetronimos.fourrotationstetronimo.JTetronimo;
import tetris.game.tetronimos.fourrotationstetronimo.LTetronimo;
import tetris.game.tetronimos.fourrotationstetronimo.TTetronimo;
import tetris.game.tetronimos.norotationstetronimo.OTetronimo;
import tetris.game.tetronimos.tworotationstetronimo.ITetronimo;
import tetris.game.tetronimos.tworotationstetronimo.STetronimo;
import tetris.game.tetronimos.tworotationstetronimo.ZTetronimo;
import tetris.input.DefaultKeyboard;
import tetris.input.Keyboard;
import tetris.output.gamerenderer.DefaultGameRenderer;
import tetris.output.gamerenderer.GameRenderer;

import java.awt.event.KeyEvent;

public class DefaultTetris implements Tetris {

    private final GameRenderer gameRenderer;
    private boolean running = true;
    private final int blocksWide = 10;
    private final int blocksHigh = 20;
    private Tetronimo currentTetronimo;
    private Tetronimo nextTetronimo;
    private boolean isPaused;
    private boolean isPlaying = false;
    protected int level = 0;
    private int rowsCleared = 0;
    protected int score = 0;
    private DefaultGrid grid;
    private boolean isGameOver = false;

    public DefaultTetris() {
        Keyboard keyboard = new DefaultKeyboard(this);
        gameRenderer = new DefaultGameRenderer(blocksWide, blocksHigh, "Tetris", keyboard);
    }

    @Override
    public void start() {
        int fps = 60;
        double oneSecond = 1000;
        double timePerTick = oneSecond / fps;
        double gameDelta = 0;
        double fallDelta = 0;
        long previousTime = System.currentTimeMillis();
        while (running) {
            double fallCountdown = isPaused ? 0 : 1.1 - (0.1 * level);
            long currentTime;
            currentTime = System.currentTimeMillis();
            gameDelta += (currentTime - previousTime) / timePerTick;
            fallDelta += (currentTime - previousTime) / oneSecond;
            previousTime = currentTime;
            if (gameDelta >= 1) {
                drawToDisplay();
                gameDelta = 0;
            }
            if (isPlaying && !isPaused && fallDelta >= fallCountdown) {
                dropTetronimo();
                fallDelta = 0;
            }
        }
    }

    @Override
    public void processKeyCode(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_N:
                newGame();
                break;
            case KeyEvent.VK_X:
                quit();
                break;
            case KeyEvent.VK_SPACE:
                isPaused = !isPaused;
                break;
            case KeyEvent.VK_RIGHT:
                moveRight();
                break;
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_E:
                rotateClockwise();
                break;
            case KeyEvent.VK_Q:
                rotateAntiClockwise();
                break;
            case KeyEvent.VK_DOWN:
                dropQuickly();
                break;
            case KeyEvent.VK_R:
                releaseTetronimo();
                break;
            case KeyEvent.VK_M:
                returnToMainScreen();
                break;
        }
    }

    @Override
    public void newGame() {
        rowsCleared = 0;
        level = 0;
        score = 0;
        gameRenderer.getListOfRenderers().clear();
        grid = new DefaultGrid(gameRenderer, blocksWide, blocksHigh);
        nextTetronimo = createRandomTetronimo();
        getNextTetronimo();
        isPlaying = true;
        isGameOver = false;
        isPaused = false;
    }

    @Override
    public void quit() {
        running = false;
        System.exit(0);
    }

    @Override
    public void moveRight() {
        if (!isPaused) {
            currentTetronimo.tryToMove(1, 0);
        }
    }

    @Override
    public void moveLeft() {
        if (!isPaused) {
            currentTetronimo.tryToMove(-1, 0);
        }
    }

    @Override
    public void rotateClockwise() {
        if (!isPaused) {
            currentTetronimo.rotateClockwise();
        }
    }

    @Override
    public void rotateAntiClockwise() {
        if (!isPaused) {
            currentTetronimo.rotateAntiClockwise();
        }
    }

    @Override
    public void dropQuickly() {
        if (!isPaused) {
            dropTetronimo();
            dropTetronimo();
            dropTetronimo();
        }
    }

    @Override
    public void releaseTetronimo() {
        if (!isPaused) {
            Tetronimo releasedTetronimo = currentTetronimo;
            while (currentTetronimo == releasedTetronimo) {
                dropTetronimo();
            }
        }
    }

    @Override
    public void returnToMainScreen() {
        gameRenderer.getListOfRenderers().clear();
        isGameOver = false;
        if (isPlaying) {
            isPlaying = false;
        }
    }

    @Override
    public void getNextTetronimo() {
        if (this.nextTetronimo.isPlayable()) {
            this.currentTetronimo = nextTetronimo;
            this.currentTetronimo.moveToGrid();
            this.nextTetronimo = createRandomTetronimo();
        } else {
            gameOver();
        }
    }

    @Override
    public void updateScore(int completedRows) {
        if (completedRows <= 0) {
            throw new IllegalArgumentException("Cannot complete a negative number of rows");
        }
        score += Math.pow(2, completedRows - 1) * (level + 1);
    }

    @Override
    public void updateRowsCleared(int completedRows) {
        int rowsToGainNextLevel = 10;
        rowsCleared += completedRows;
        if (rowsCleared >= ((level + 1) * rowsToGainNextLevel)) {
            increaseLevel();
        }
    }

    @Override
    public void increaseLevel() {
        int highestLevel = 10;
        level = Math.min(highestLevel, ++level);
    }

    @Override
    public void gameOver() {
        this.isGameOver = true;
        isPlaying = false;
    }

    private void drawToDisplay() {
        gameRenderer.updateDisplay(isPaused, rowsCleared, level, score, isGameOver);
    }

    private Tetronimo createRandomTetronimo() {
        int numberOfTetronimos = 7;
        int randomNumber = (int) (Math.random() * numberOfTetronimos);
        switch (randomNumber) {
            case 0:
                return new ITetronimo(grid, gameRenderer);
            case 1:
                return new JTetronimo(grid, gameRenderer);
            case 2:
                return new LTetronimo(grid, gameRenderer);
            case 3:
                return new TTetronimo(grid, gameRenderer);
            case 4:
                return new STetronimo(grid, gameRenderer);
            case 5:
                return new ZTetronimo(grid, gameRenderer);
            default:
                return new OTetronimo(grid, gameRenderer);
        }
    }

    private void dropTetronimo() {
        if (!currentTetronimo.canFall()) {
            int completedRows = grid.checkForCompletedRows();
            if (completedRows > 0) {
                updateScore(completedRows);
                updateRowsCleared(completedRows);
                if (grid.getIsEmpty()) {
                    System.out.println("empty grid");
                    updateScore(blocksWide);
                }
            }
            getNextTetronimo();
        }
    }

}
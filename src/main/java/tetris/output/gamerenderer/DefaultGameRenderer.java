package tetris.output.gamerenderer;

import tetris.output.background.Background;
import tetris.output.background.TetrisBackground;
import tetris.output.display.Display;
import tetris.output.display.Window;
import tetris.output.itemrenderers.ItemRenderer;
import tetris.validation.ObjectValidator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collection;

public class DefaultGameRenderer implements GameRenderer, ActionListener {

    private final int gridHorizontalCoordinate;
    private final int gridVerticalCoordinate;
    private final int displayWidth = 800;
    private final int displayHeight = 600;
    private final int blockSize = 24;
    private final Background backgroundImage;
    private final Collection<ItemRenderer> itemRenderers;
    private final Collection<ItemRenderer> renderersToRemove;
    private final Collection<ItemRenderer> renderersToAdd;
    private final Display display;
    private boolean isPaused;
    private final Font simpleFont = new Font("Helvetica", Font.PLAIN, 18);
    private final Font largeFont = new Font("Helvetica", Font.BOLD, 50);
    private final int textHorizontalCoordinate = 558;

    public DefaultGameRenderer(int blocksWide, int blocksHigh, String title, KeyListener keyListener) {
        ObjectValidator.ValidateObjectNotNull(title, "title");
        ObjectValidator.ValidateObjectNotNull(keyListener, "keyListener");
        gridHorizontalCoordinate = (displayWidth - blockSize * blocksWide) / 2;
        gridVerticalCoordinate = (displayHeight - blockSize * blocksHigh) * 2 / 3;
        backgroundImage = new TetrisBackground("src/main/resources/background.png");
        itemRenderers = new ArrayList<>();
        renderersToRemove = new ArrayList<>();
        renderersToAdd = new ArrayList<>();
        display = new Window(displayWidth, displayHeight, title, keyListener);
    }

    @Override
    public void updateDisplay(boolean isPaused, int rowsCleared, int level, int score, boolean isGameOver) {
        this.isPaused = isPaused;
        this.display.getCanvas().createBufferStrategy(2);
        BufferStrategy bufferStrategy = display.getCanvas().getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, displayWidth, displayHeight);
        updateRenderers();
        draw(graphics, rowsCleared, level, score);
        if (isGameOver) {
            displayGameOver(graphics);
        }
        graphics.dispose();
        bufferStrategy.show();
    }

    @Override
    public Collection<ItemRenderer> getListOfRenderers() {
        return itemRenderers;
    }

    @Override
    public Collection<ItemRenderer> getRenderersToRemove() {
        return renderersToRemove;
    }

    @Override
    public Collection<ItemRenderer> getRenderersToAdd() {
        return renderersToAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public int getBlockSize() {
        return blockSize;
    }

    @Override
    public int getDisplayWidth() {
        return displayWidth;
    }

    @Override
    public int getDisplayHeight() {
        return displayHeight;
    }

    @Override
    public int getGridHorizontalCoordinate() {
        return gridHorizontalCoordinate;
    }

    @Override
    public int getGridVerticalCoordinate() {
        return gridVerticalCoordinate;
    }

    @Override
    public boolean getIsPaused() {
        return isPaused;
    }

    private void updateRenderers() {
        itemRenderers.removeAll(renderersToRemove);
        renderersToRemove.clear();
        itemRenderers.addAll(renderersToAdd);
        renderersToAdd.clear();
    }

    private void draw(Graphics graphics, int rowsCleared, int level, int score) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        drawBackground(graphics);
        drawItems(graphics);
        displayRowsCleared(graphics, rowsCleared);
        displayLevel(graphics, level);
        displayScore(graphics, score);
        displayNextBlock(graphics);
    }

    private void drawBackground(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        if (backgroundImage.getImage() != null) {
            graphics.drawImage(backgroundImage.getImage(), 0, 0, displayWidth, displayHeight, Color.WHITE, null);
        }
    }

    private void drawItems(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        for (ItemRenderer itemRenderer : itemRenderers) {
            itemRenderer.drawItem(graphics);
        }
    }

    private void displayRowsCleared(Graphics graphics, int rowsCleared) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int rowsClearedVerticalCoordinate = 200;
        displayText(graphics, "Rows Cleared: " + rowsCleared, simpleFont, textHorizontalCoordinate, rowsClearedVerticalCoordinate);
    }

    private void displayLevel(Graphics graphics, int level) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int levelVerticalCoordinate = 230;
        displayText(graphics, "Level: " + level, simpleFont, textHorizontalCoordinate, levelVerticalCoordinate);

    }

    private void displayScore(Graphics graphics, int score) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int scoreVerticalCoordinate = 260;
        displayText(graphics, "Score: " + score, simpleFont, textHorizontalCoordinate, scoreVerticalCoordinate);
    }

    private void displayNextBlock(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int scoreVerticalCoordinate = 410;
        displayText(graphics, "Next Block: ", simpleFont, textHorizontalCoordinate, scoreVerticalCoordinate);
    }

    private void displayGameOver(Graphics graphics) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        int gameOverHorizontalCoordinate = 246;
        int gameOverVerticalCoordinate = 280;
        displayText(graphics,"GAME OVER", largeFont, gameOverHorizontalCoordinate, gameOverVerticalCoordinate);
    }

    private void displayText(Graphics graphics, String text, Font font, int horizontalCoordinate, int verticalCoordinate) {
        ObjectValidator.ValidateObjectNotNull(graphics, "graphics");
        ObjectValidator.ValidateObjectNotNull(text, "text");
        ObjectValidator.ValidateObjectNotNull(font, "font");
        graphics.setColor(Color.white);
        graphics.setFont(font);
        graphics.drawString(text, horizontalCoordinate, verticalCoordinate);
    }

}
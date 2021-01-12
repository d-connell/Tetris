package tetris.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface Keyboard extends KeyListener {

    @Override
    default void keyTyped(KeyEvent e) {
    }

    @Override
    default void keyPressed(KeyEvent e) {
        processKeyPress(e.getKeyCode());
    }

    @Override
    default void keyReleased(KeyEvent e) {
    }

    void processKeyPress(int keyCode);

}